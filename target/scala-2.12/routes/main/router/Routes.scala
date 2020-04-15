// @GENERATOR:play-routes-compiler
// @SOURCE:/home/david/Documents/interview/transaction/conf/routes
// @DATE:Wed Apr 15 00:46:10 CDT 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  Application_0: controllers.Application,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    Application_0: controllers.Application
  ) = this(errorHandler, Application_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Application.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """data""", """controllers.Application.data"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Application.login"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Application.doLogin"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """restricted""", """controllers.Application.restricted"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """transactions""", """controllers.Application.getTransaction"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """summary""", """controllers.Application.getSummary"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete""", """controllers.Application.deleteTransaction(userCode:String = "stests")"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """insert""", """controllers.Application.insertTransaction"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_Application_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Application_versioned1_invoker = createInvoker(
    Application_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_Application_data2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("data")))
  )
  private[this] lazy val controllers_Application_data2_invoker = createInvoker(
    Application_0.data,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "data",
      Nil,
      "GET",
      this.prefix + """data""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_Application_login3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Application_login3_invoker = createInvoker(
    Application_0.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "login",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_doLogin4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Application_doLogin4_invoker = createInvoker(
    Application_0.doLogin,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "doLogin",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_restricted5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("restricted")))
  )
  private[this] lazy val controllers_Application_restricted5_invoker = createInvoker(
    Application_0.restricted,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "restricted",
      Nil,
      "GET",
      this.prefix + """restricted""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Application_getTransaction6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("transactions")))
  )
  private[this] lazy val controllers_Application_getTransaction6_invoker = createInvoker(
    Application_0.getTransaction,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getTransaction",
      Nil,
      "GET",
      this.prefix + """transactions""",
      """ core implementation idea here
 ideally shouldnt be their own pages but are supplments to the current pages
 todo: later implementation should have a query to filter, delete and insert""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Application_getSummary7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("summary")))
  )
  private[this] lazy val controllers_Application_getSummary7_invoker = createInvoker(
    Application_0.getSummary,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getSummary",
      Nil,
      "GET",
      this.prefix + """summary""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Application_deleteTransaction8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete")))
  )
  private[this] lazy val controllers_Application_deleteTransaction8_invoker = createInvoker(
    Application_0.deleteTransaction(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "deleteTransaction",
      Seq(classOf[String]),
      "POST",
      this.prefix + """delete""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Application_insertTransaction9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("insert")))
  )
  private[this] lazy val controllers_Application_insertTransaction9_invoker = createInvoker(
    Application_0.insertTransaction,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "insertTransaction",
      Nil,
      "POST",
      this.prefix + """insert""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_Application_index0_route(params@_) =>
      call { 
        controllers_Application_index0_invoker.call(Application_0.index)
      }
  
    // @LINE:3
    case controllers_Application_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Application_versioned1_invoker.call(Application_0.versioned(path, file))
      }
  
    // @LINE:5
    case controllers_Application_data2_route(params@_) =>
      call { 
        controllers_Application_data2_invoker.call(Application_0.data)
      }
  
    // @LINE:6
    case controllers_Application_login3_route(params@_) =>
      call { 
        controllers_Application_login3_invoker.call(Application_0.login)
      }
  
    // @LINE:7
    case controllers_Application_doLogin4_route(params@_) =>
      call { 
        controllers_Application_doLogin4_invoker.call(Application_0.doLogin)
      }
  
    // @LINE:8
    case controllers_Application_restricted5_route(params@_) =>
      call { 
        controllers_Application_restricted5_invoker.call(Application_0.restricted)
      }
  
    // @LINE:13
    case controllers_Application_getTransaction6_route(params@_) =>
      call { 
        controllers_Application_getTransaction6_invoker.call(Application_0.getTransaction)
      }
  
    // @LINE:14
    case controllers_Application_getSummary7_route(params@_) =>
      call { 
        controllers_Application_getSummary7_invoker.call(Application_0.getSummary)
      }
  
    // @LINE:15
    case controllers_Application_deleteTransaction8_route(params@_) =>
      call(Param[String]("userCode", Right("stests"))) { (userCode) =>
        controllers_Application_deleteTransaction8_invoker.call(Application_0.deleteTransaction(userCode))
      }
  
    // @LINE:16
    case controllers_Application_insertTransaction9_route(params@_) =>
      call { 
        controllers_Application_insertTransaction9_invoker.call(Application_0.insertTransaction)
      }
  }
}
