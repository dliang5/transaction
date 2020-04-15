// @GENERATOR:play-routes-compiler
// @SOURCE:/home/david/Documents/interview/transaction/conf/routes
// @DATE:Tue Apr 14 22:28:24 CDT 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.javascript {

  // @LINE:1
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
    // @LINE:13
    def getTransaction: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getTransaction",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "transactions"})
        }
      """
    )
  
    // @LINE:14
    def getSummary: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getSummary",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "summary"})
        }
      """
    )
  
    // @LINE:16
    def insertTransaction: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.insertTransaction",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "insert"})
        }
      """
    )
  
    // @LINE:7
    def doLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.doLogin",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:5
    def data: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.data",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "data"})
        }
      """
    )
  
    // @LINE:8
    def restricted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.restricted",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "restricted"})
        }
      """
    )
  
    // @LINE:1
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:6
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:15
    def deleteTransaction: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.deleteTransaction",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delete"})
        }
      """
    )
  
  }


}
