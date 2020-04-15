package controllers

import java.util.concurrent.TimeUnit

import actors.StatsActor
import akka.actor.ActorSystem
import akka.util.Timeout
import akka.pattern.ask
import controllers.Assets.Asset
import play.api.libs.json.Json
import play.api.mvc._
import services.{AuthService, TransactionService, UserAuthAction}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json

import scala.concurrent.ExecutionContext.Implicits.global

case class UserLoginData(username: String, password: String)
case class TransactionForm(transactionAmount: Int)
class Application (
    components: ControllerComponents, assets: Assets, authService: AuthService,
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

  def getTransaction = Action { implicit request =>
    Ok(Json.toJson(transactionService.getTransactions))
  }
    def getSummary = Action { implicit request =>
    Ok(Json.toJson(transactionService.getSummary))
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


  def data = Action { implicit request =>
    Ok(Json.toJson(transactionService.setUpTransactions))
  }


  def versioned(path: String, file: Asset) = assets.versioned(path, file)
}
