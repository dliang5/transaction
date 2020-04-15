import com.softwaremill.macwire._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds, Span}
import org.scalatestplus.play.PlaySpec
import play.api.ApplicationLoader.Context
import play.api.{BuiltInComponentsFromContext, NoHttpFiltersComponents}
import play.api.libs.ws.ahc.AhcWSComponents
import play.api.routing.Router

class TestAppComponents(context: Context)
  extends BuiltInComponentsFromContext(context)
    with NoHttpFiltersComponents
    with AhcWSComponents {

  lazy val router: Router = Router.empty
}


import org.scalatestplus.play.components.OneAppPerSuiteWithComponents
class WeatherServiceSpec extends PlaySpec
  with OneAppPerSuiteWithComponents
  with ScalaFutures {

  override def components = new TestAppComponents(context)

  override implicit val patienceConfig =
    PatienceConfig(timeout = Span(5, Seconds))

}