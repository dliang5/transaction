
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Option[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(maybeErrorMessage: Option[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""<html lang="en">
<head>
    <title>Login page</title>
    <link rel="stylesheet"
          href=""""),_display_(/*7.18*/routes/*7.24*/.Application.versioned("compiled/styles.css")),format.raw/*7.69*/("""">
    <link rel="shortcut icon" type="image/png"
          href=""""),_display_(/*9.18*/routes/*9.24*/.Application.versioned("images/favicon.png")),format.raw/*9.68*/("""">
</head>
<body>
<form method="post" action="/login">
    <fieldset style="margin: 10px;">
        <legend>Login</legend>
        """),_display_(/*15.10*/maybeErrorMessage/*15.27*/.map/*15.31*/ { errorMessage =>_display_(Seq[Any](format.raw/*15.49*/("""
            """),format.raw/*16.13*/("""<span class="label bg--error">"""),_display_(/*16.44*/errorMessage),format.raw/*16.56*/("""</span>
        """)))}),format.raw/*17.10*/("""
        """),format.raw/*18.9*/("""<p>
            <label for="username">Username:</label>
            <input id="username" type="text" name="username"  />
        </p>
        <p>
            <label for="password">Password:</label>
            <input id="password" type="password" name="password"  />
        </p>
        <button type="submit" class="button--sm">Login</button>
    </fieldset>
</form>
</body>
</html>"""))
      }
    }
  }

  def render(maybeErrorMessage:Option[String]): play.twirl.api.HtmlFormat.Appendable = apply(maybeErrorMessage)

  def f:((Option[String]) => play.twirl.api.HtmlFormat.Appendable) = (maybeErrorMessage) => apply(maybeErrorMessage)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Apr 12 13:13:25 CDT 2020
                  SOURCE: /home/david/Documents/interview/transaction/app/views/login.scala.html
                  HASH: e06f07f30d3fc76b8ff311ce53696a4e67744f0c
                  MATRIX: 737->2|866->38|990->136|1004->142|1069->187|1162->254|1176->260|1240->304|1399->436|1425->453|1438->457|1494->475|1535->488|1593->519|1626->531|1674->548|1710->557
                  LINES: 21->2|26->3|30->7|30->7|30->7|32->9|32->9|32->9|38->15|38->15|38->15|38->15|39->16|39->16|39->16|40->17|41->18
                  -- GENERATED --
              */
          