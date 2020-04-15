
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
        <div id="reactView"></div>
    </body>
    <script src=""""),_display_(/*13.19*/routes/*13.25*/.Application.versioned("compiled/bundle.js")),format.raw/*13.69*/("""" ></script>
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
                  DATE: Mon Apr 13 23:36:19 CDT 2020
                  SOURCE: /home/david/Documents/interview/transaction/app/views/index.scala.html
                  HASH: 2a665e64476eeb588235e7244a52d9853d117155
                  MATRIX: 722->1|818->4|954->114|968->120|1034->166|1132->238|1146->244|1210->288|1328->379|1343->385|1408->429
                  LINES: 21->1|26->2|30->6|30->6|30->6|32->8|32->8|32->8|37->13|37->13|37->13
                  -- GENERATED --
              */
          