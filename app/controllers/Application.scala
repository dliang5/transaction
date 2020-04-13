package controllers

import java.util.concurrent.TimeUnit

import model.CombinedData
import actors.StatsActor
import akka.actor.ActorSystem
import akka.util.Timeout
import akka.pattern.ask
import controllers.Assets.Asset
import play.api.libs.json.Json
import play.api.mvc._
import services.{AuthService, SunService, TransactionService, UserAuthAction, WeatherService}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json

import scala.concurrent.ExecutionContext.Implicits.global

case class UserLoginData(username: String, password: String)

class Application (
    components: ControllerComponents, assets: Assets,
    sunService: SunService, weatherService: WeatherService,
    actorSystem: ActorSystem, authService: AuthService,
    userAuthAction: UserAuthAction, transactionService: TransactionService)
    extends AbstractController(components) {

  val userDataForm = Form {
    mapping(
      "username" -> nonEmptyText,
      "password" -> nonEmptyText
    )(UserLoginData.apply)(UserLoginData.unapply)
  }

  def index = Action {
    Ok(views.html.index())
  }

  def login = Action {
    Ok(views.html.login(None))
  }

  def doLogin = Action { implicit request =>
    userDataForm.bindFromRequest.fold(
      formWithErrors => BadRequest,
      userData => {
        val maybeCookie = authService.login(
          userData.username, userData.password)
        maybeCookie match {
          case Some(cookie) => Redirect("/").withCookies(cookie)
          case None => Ok(views.html.login(Some("Login failed")))
        }
      }
    )
  }

  def restricted = userAuthAction { userAuthRequest =>
    Ok(views.html.restricted(userAuthRequest.user))
  }

  def data = Action.async {
    val lat = -33.8830
    val lon = 151.2167
    val sunInfoF = sunService.getSunInfo(lat, lon)
    val temperateF = weatherService.getTemperature(lat, lon)
    implicit val timeout = Timeout(5, TimeUnit.SECONDS)
    val requestsF = (actorSystem.actorSelection(StatsActor.path) ?
      StatsActor.GetStats).mapTo[Int]
    for {
      sunInfo <- sunInfoF
      temperature <- temperateF
      requests <- requestsF
    } yield {
      Ok(Json.toJson(CombinedData(sunInfo, temperature, requests)))
    }
  }

  def getTransaction(userCode: String) = Action { implicit request =>
    Ok(Json.toJson(transactionService.getTransactions(userCode)))
  }
    def getSummary(userCode: String) = Action { implicit request =>
    Ok(Json.toJson(transactionService.getSummary(userCode)))
  }
    def deleteTransaction(userCode: String) = Action { implicit request =>
    Ok(Json.toJson(transactionService.deleteTransaction(userCode)))
  }
    def insertTransaction(userCode: String) = Action { implicit request =>
    Ok(Json.toJson(transactionService.insertTransaction(userCode)))
  }

  def versioned(path: String, file: Asset) = assets.versioned(path, file)
}
