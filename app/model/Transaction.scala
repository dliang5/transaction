package model

import java.util.{Date, UUID}

import play.api.libs.json.Json

case class Transaction(userId: UUID, transactionId: Int,
                       transactionAmount: Int, transactionDate: Date)

object Transaction {
  implicit val writes = Json.writes[Transaction]
}
