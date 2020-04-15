package model

import play.api.libs.json.Json

case class TransactionSummary(userId: String,
                              transactionMonth1: Int,
                              transactionMonth2: Int,
                              transactionMonth3: Int,
                              transactionTotal: Int)
object TransactionSummary {
  implicit val writes = Json.writes[TransactionSummary]
}
