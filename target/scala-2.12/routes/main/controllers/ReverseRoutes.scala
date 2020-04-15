// @GENERATOR:play-routes-compiler
// @SOURCE:/home/david/Documents/interview/transaction/conf/routes
// @DATE:Tue Apr 14 22:53:25 CDT 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers {

  // @LINE:1
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
    // @LINE:13
    def getTransaction(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "transactions")
    }
  
    // @LINE:14
    def getSummary(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "summary")
    }
  
    // @LINE:16
    def insertTransaction(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "insert")
    }
  
    // @LINE:7
    def doLogin(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:5
    def data(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "data")
    }
  
    // @LINE:8
    def restricted(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "restricted")
    }
  
    // @LINE:1
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:6
    def login(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:15
    def deleteTransaction(): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("userCode", "stests"))); _rrc
      Call("POST", _prefix + { _defaultPrefix } + "delete")
    }
  
  }


}
