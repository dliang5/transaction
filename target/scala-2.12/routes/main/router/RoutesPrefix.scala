// @GENERATOR:play-routes-compiler
// @SOURCE:/home/david/Documents/interview/transaction/conf/routes
// @DATE:Mon Apr 13 22:29:35 CDT 2020


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
