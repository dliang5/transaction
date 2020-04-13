package model

import java.util.{Date, UUID}

import play.api.libs.json.Json

case class TransactionSummary(userId: String, transactionSummaryId: Int,
                              transactionMonth1: Int,
                              transactionMonth2: Int,
                              transactionMonth3: Int,
                              transactionMonth4: Int,
                              transactionMonth5: Int,
                              transactionMonth6: Int,
                              transactionMonth7: Int,
                              transactionMonth8: Int,
                              transactionMonth9: Int,
                              transactionMonth10: Int,
                              transactionMonth11: Int,
                              transactionMonth12: Int,
                              transactionYear: Int)

case class TransactionRewardSummary(userId: String, transactionSummaryId: Int,
                              transactionMonth1: Int,
                              transactionMonth2: Int,
                              transactionMonth3: Int,
                              transactionMonth4: Int,
                              transactionMonth5: Int,
                              transactionMonth6: Int,
                              transactionMonth7: Int,
                              transactionMonth8: Int,
                              transactionMonth9: Int,
                              transactionMonth10: Int,
                              transactionMonth11: Int,
                              transactionMonth12: Int,
                              transactionYear: Int)
object TransactionSummary {
  implicit val writes = Json.writes[TransactionSummary]
}
