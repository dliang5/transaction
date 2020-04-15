package services
import model.{Transaction, TransactionSummary}
import scalikejdbc._
import scala.collection.mutable.HashMap
import scala.concurrent.Future
import java.text.SimpleDateFormat
import java.util.Date

import scala.concurrent.ExecutionContext.Implicits.global
class TransactionService {
  // this is your standard getAll of the transaction
  // possibly of having it filter the results by month
  // right now, anyone can see the result of the transactions
  // as long as they have user access - user specific in future tho
  def getTransactions(userCode: String): List[Transaction] = {
    DB.readOnly { implicit session =>
      val select = sql"select * from transactions where user_id = $userCode"
        .map{ rs =>
          Transaction(userCode, rs.int("transaction_id"),
            rs.int("transaction_amount"),
            rs.date("transaction_date"), convertAmountToRewards(rs.int("transaction_amount")))
        }.list.apply()
      select
    }
  }

  def getTransactions1(userCode: String): Future[List[Transaction]] = {

    DB.futureLocalTx { implicit session =>
      val select = sql"select * from transactions where user_id = $userCode"
        .map{ rs =>
          Transaction(userCode, rs.int("transaction_id"),
            rs.int("transaction_amount"),
            rs.date("transaction_date"))
        }.list.apply()

      Future(select)
    }
  }

  def getSummary(userCode: String): TransactionSummary = {
    val summaryValues = new HashMap[String,Int]()
    var summaryYear = 0

    getTransactions(userCode).map { record =>
      val dateStr = record.transactionDate.toString().split("-")(1).toInt.toString()
      if (!summaryValues.contains(dateStr)) {
        summaryValues.put(dateStr, record.transactionRewards)
      } else {
        summaryValues.update(dateStr, summaryValues(dateStr) + record.transactionRewards)
      }
      summaryYear += record.transactionRewards
    }

    // test driving it, keep it at 1 right now
    // todo: have a checker on the database to find the most recent number or id used
    val keys = summaryValues.keys.map(_.toInt).toList.sorted.map(_.toString)
    TransactionSummary(
      userCode,
      summaryValues(keys(0)), summaryValues(keys(1)), summaryValues(keys(2)),
      summaryYear
    )
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
      val entrySize = getTransactions(userCode).size
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
