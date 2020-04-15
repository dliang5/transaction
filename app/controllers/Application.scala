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
case class TransactionForm(transactionAmount: Int)
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

  val transactionForm = Form {
    mapping(
      "transactionAmount" -> number
    )(TransactionForm.apply)(TransactionForm.unapply)
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


  def transactions(userCode: String) = Action.async {
    val transactionInfoF = transactionService.getTransactions1(userCode)
    implicit val timeout = Timeout(5, TimeUnit.SECONDS)
    for {
      transactions <- transactionInfoF
    } yield {
      Ok(Json.toJson(transactions))
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
    def insertTransaction = Action { implicit request =>
      transactionForm.bindFromRequest.fold(
        formWithErrors => BadRequest,
        userData => {
          transactionService.insertTransaction("Anonymous Billy", userData.transactionAmount)
          Redirect("/")
        }
      )
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


  def versioned(path: String, file: Asset) = assets.versioned(path, file)
}
