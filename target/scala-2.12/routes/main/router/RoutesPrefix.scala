// @GENERATOR:play-routes-compiler
// @SOURCE:/home/david/Documents/interview/transaction/conf/routes
// @DATE:Tue Apr 14 22:28:24 CDT 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
