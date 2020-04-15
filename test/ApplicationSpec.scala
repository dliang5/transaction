import java.time.format.DateTimeFormatter
import java.time.{Instant, ZoneId, ZonedDateTime}

import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play._
import org.scalatest.concurrent._
import org.mockito.Mockito._
import play.api.libs.json.Json
import play.api.libs.ws.ahc.AhcWSRequest
import play.api.libs.ws.{WSClient, WSResponse}

import scala.concurrent.Future

class ApplicationSpec extends PlaySpec with MockitoSugar with ScalaFutures {

  "DateTimeFormat" must {
    "return 1970 as the beginning of epoch" in {
      val beginning = ZonedDateTime.ofInstant(Instant.ofEpochSecond(0),
        ZoneId.systemDefault())
      val formattedYear = beginning.format(DateTimeFormatter.ofPattern("YYYY"))
      formattedYear mustBe "1970"
    }
  }
}