package services

import java.time.format.DateTimeFormatter
import java.util.UUID

import model.{Transaction, TransactionSummary}
import scalikejdbc._

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
            rs.date("transaction_date"))
        }.list.apply()
      println("this is the transactions in here", select, userCode)
      select
    }
  }

  def getSummary(userCode: String): TransactionSummary = {
    val summaryValues: scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map(1 -> 0,
      2 -> 0, 3 -> 0, 4 -> 0, 5 -> 0, 6 -> 0, 7 -> 0, 8 -> 0, 9 -> 0, 10 -> 0, 11 -> 0, 12 -> 0
    )
    var summaryYear = 0

    getTransactions(userCode).map { record =>
      val dateStr = record.transactionDate.toString().split("-")
      summaryValues(dateStr(1).toInt) = summaryValues(dateStr(1).toInt) + record.transactionAmount
      summaryYear += record.transactionAmount
    }

    // test driving it, keep it at 1 right now
    // todo: have a checker on the database to find the most recent number or id used
    TransactionSummary(
      userCode, 1,
      summaryValues(1), summaryValues(2), summaryValues(3),
      summaryValues(4), summaryValues(5), summaryValues(6),
      summaryValues(7), summaryValues(8), summaryValues(9),
      summaryValues(10), summaryValues(11), summaryValues(12),
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
  def insertTransaction(userCode: String) = {
    DB.localTx{ implicit session =>
      sql"insert into transactions where user_id = $userCode"
        .update.apply()
    }
  }

  private[this] def convertAmountToRewards(amount: Int): Int = {
    println("this is the amount in here", amount)
    if (amount > 50 && amount <= 100) {
      amount - 50
    } else if (amount > 100) {
      50 + ((amount - 100) * 2)
    } else {
      0
    }
  }
}
