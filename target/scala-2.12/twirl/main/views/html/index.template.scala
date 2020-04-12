
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Home</title>
        <link rel="stylesheet" href=""""),_display_(/*6.39*/routes/*6.45*/.Application.versioned("compiled/>styles.css")),format.raw/*6.91*/("""">
        <link rel="shortcut icon" type="image/png"
           href=""""),_display_(/*8.19*/routes/*8.25*/.Application.versioned("images/favicon.png")),format.raw/*8.69*/("""">
    </head>
    <body>
        <h1>Hello Play</h1>
        <div id="reactView"></div>
    </body>
    <script src=""""),_display_(/*14.19*/routes/*14.25*/.Application.versioned("compiled/bundle.js")),format.raw/*14.69*/("""" ></script>
</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Apr 12 09:30:15 CDT 2020
                  SOURCE: /home/david/Documents/interview/transaction/app/views/index.scala.html
                  HASH: a5ed05066d68fdb4d1af20e4df5747fdae44a5ff
                  MATRIX: 722->1|818->4|954->114|968->120|1034->166|1132->238|1146->244|1210->288|1356->407|1371->413|1436->457
                  LINES: 21->1|26->2|30->6|30->6|30->6|32->8|32->8|32->8|38->14|38->14|38->14
                  -- GENERATED --
              */
          