import controllers.Application
import play.api.ApplicationLoader.Context
import play.api._
import play.api.libs.ws.ahc.AhcWSComponents
import play.api.mvc._
import router.Routes
import play.api.routing.Router
import com.softwaremill.macwire._
import _root_.controllers.AssetsComponents
import actors.StatsActor
import actors.StatsActor.Ping
import akka.actor.Props
import filters.StatsFilter
import play.api.cache.ehcache.EhCacheComponents
import play.api.db.{DBComponents, HikariCPComponents}
import play.api.db.evolutions.{DynamicEvolutions, EvolutionsComponents}
import play.filters.HttpFiltersComponents
import scalikejdbc.config.DBs
import services.{AuthService, TransactionService, UserAuthAction}

import scala.concurrent.Future

class AppApplicationLoader extends ApplicationLoader {
  def load(context: Context) = {
    LoggerConfigurator(context.environment.classLoader).foreach { cfg =>
      cfg.configure(context.environment)
    }
    new AppComponents(context).application
  }
}

class AppComponents(context: Context) extends BuiltInComponentsFromContext(context)
  with AhcWSComponents with EvolutionsComponents with DBComponents
  with HikariCPComponents with EhCacheComponents with AssetsComponents with HttpFiltersComponents {

  override lazy val controllerComponents = wire[DefaultControllerComponents]
  lazy val prefix: String = "/"
  lazy val router: Router = wire[Routes]
  lazy val applicationController = wire[Application]
  lazy val statsFilter: Filter = wire[StatsFilter]
  override lazy val httpFilters = Seq(statsFilter)
  lazy val statsActor = actorSystem.actorOf(
    Props(wire[StatsActor]), StatsActor.name)
  lazy val authService = new AuthService(defaultCacheApi.sync)

  lazy val userAuthAction = wire[UserAuthAction]
  lazy val transactionService = new TransactionService
  override lazy val dynamicEvolutions = new DynamicEvolutions
  applicationLifecycle.addStopHook { () =>
    Logger.info("The app is about to stop")
    DBs.closeAll()
    Future.successful(Unit)
  }

  val onStart = {
    Logger.info("the app is about to start")
    DBs.setupAll()
    applicationEvolutions
    statsActor ! Ping
  }
}
