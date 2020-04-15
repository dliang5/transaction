package services
import model.{Transaction, TransactionSummary}
import scalikejdbc._

import scala.collection.mutable.HashMap
import scala.concurrent.Future
import java.text.SimpleDateFormat
import java.util.Date

import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.Source
class TransactionService {

  // todo: for some odd reason this just doesn't want to work
  // ill just manually do it with the random generator first
  def setUpTransactions: Int = {
    val currentDirectory = new java.io.File(".").getCanonicalPath
    println("im in here", currentDirectory)
    val filename = currentDirectory + "/app/data/data.csv"
    var sqlCommand = "insert into transactions (user_id, transaction_id, transaction_amount, transaction_date) values "

    for (line: String <- Source.fromFile(filename).getLines){
      val recordInfo = line.trim.stripMargin.split(",").toList
      val name = recordInfo(0)
      val id = recordInfo(1)
      val amount = recordInfo(2)
      val format = new java.text.SimpleDateFormat("yyyy-MM-dd")
      val date = recordInfo(3)
      val currentEntry = s"($name, $id, $amount, $date),"
      sqlCommand += currentEntry
    }
    sqlCommand = sqlCommand.dropRight(1)

    DB.localTx{ implicit session =>
      sql"insert into transactions (user_id, transaction_id, transaction_amount, transaction_date) values $sqlCommand".update.apply()
    }
    1
  }

  // this is your standard getAll of the transaction
  // possibly of having it filter the results by month
  // right now, anyone can see the result of the transactions
  // as long as they have user access - user specific in future tho
  def getTransactions: List[Transaction] = {
    DB.readOnly { implicit session =>
      val select = sql"select * from transactions"
        .map{ rs =>
          Transaction(rs.string("user_id"), rs.int("transaction_id"),
            rs.int("transaction_amount"),
            rs.date("transaction_date"), convertAmountToRewards(rs.int("transaction_amount")))
        }.list.apply()
      select
    }
  }

  def getTransactions1: Future[List[Transaction]] = {

    DB.futureLocalTx { implicit session =>
      val select = sql"select * from transactions"
        .map{ rs =>
          Transaction(rs.string("user_id"), rs.int("transaction_id"),
            rs.int("transaction_amount"),
            rs.date("transaction_date"))
        }.list.apply()

      Future(select)
    }
  }

  def getSummary: List[TransactionSummary] = {
    val summaryValues = new HashMap[String, HashMap[String, Int]]
    val summaryYear = new HashMap[String, Int]
    var dates: List[String] = List()
    getTransactions.map { record =>
      val dateStr = record.transactionDate.toString().split("-")(1).toInt.toString()
      if (!summaryValues.contains(record.userId)) {
        summaryValues.put(record.userId, new HashMap[String, Int])
        summaryYear.put(record.userId, 0)
      }

      if (!summaryValues(record.userId).contains(dateStr)) {
        summaryValues(record.userId).put(dateStr, record.transactionRewards)
        dates = List(dateStr) ::: dates
      } else {
        summaryValues(record.userId).update(dateStr, summaryValues(record.userId)(dateStr) + record.transactionRewards)
      }



      if (!summaryYear.contains(record.userId)) {
        summaryYear.put(record.userId, record.transactionRewards)
      } else {
        summaryYear.update(record.userId, summaryYear(record.userId) + record.transactionRewards)
      }
    }

    val ids = summaryValues.keys.toList
    ids.map { id =>
      dates.distinct.foreach { date =>
        if (!summaryValues(id).contains(date)) {
          summaryValues(id).put(date, 0)
        }
      }
      val keys = summaryValues(id).keys.map(_.toInt).toList.sorted.map(_.toString)
      TransactionSummary(
        id, summaryValues(id)(keys(0)), summaryValues(id)(keys(1)), summaryValues(id)(keys(2)), summaryYear(id)
      )
    }
  }

  // should be able to delete based on user selection
  // delete based on userid and date and index?
  def deleteTransaction(userCode: String) = {
    DB.localTx{ implicit session =>
      sql"delete from transactions where user_id = $userCode"
        .update.apply()
    }
  }

  // create a form from the frontend and pass a json up here
  def insertTransaction(userCode: String, amount: Int): Int = {
    DB.localTx{ implicit session =>

      val date = new Date
      val sdf = new SimpleDateFormat("yyyy-MM-dd")
      val fixedDate = sdf.format(date)
      val entrySize = getTransactions.size
      sql"insert into transactions (user_id, transaction_id, transaction_amount, transaction_date) values ($userCode, $entrySize, $amount, $date)"
        .update.apply()
    }
  }

  private[this] def convertAmountToRewards(amount: Int): Int = {
    if (amount > 50 && amount <= 100) {
      amount - 50
    } else if (amount > 100) {
      50 + ((amount - 100) * 2)
    } else {
      0
    }
  }
}
