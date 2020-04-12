
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

object restricted extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[model.User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(user: model.User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <title>Restricted</title>
    <link rel="stylesheet" href=""""),_display_(/*7.35*/routes/*7.41*/.Application.versioned("compiled/styles.css")),format.raw/*7.86*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*8.55*/routes/*8.61*/.Application.versioned("images/favicon.png")),format.raw/*8.105*/("""">
</head>
<body>
<h1>Hello """),_display_(/*11.12*/user/*11.16*/.userCode),format.raw/*11.25*/("""</h1>
<div>Your id is """),_display_(/*12.18*/user/*12.22*/.userId),format.raw/*12.29*/("""</div>
</body>
</html>"""))
      }
    }
  }

  def render(user:model.User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((model.User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Apr 12 13:38:58 CDT 2020
                  SOURCE: /home/david/Documents/interview/transaction/app/views/restricted.scala.html
                  HASH: 5d0d68b9dd7b81459be4284c25696d8be74f9d58
                  MATRIX: 738->2|850->21|980->125|994->131|1059->176|1142->233|1156->239|1221->283|1277->312|1290->316|1320->325|1370->348|1383->352|1411->359
                  LINES: 21->2|26->3|30->7|30->7|30->7|31->8|31->8|31->8|34->11|34->11|34->11|35->12|35->12|35->12
                  -- GENERATED --
              */
          