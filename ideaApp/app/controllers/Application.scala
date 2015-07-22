package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
 }
 def userlogin = Action { implicit request =>
		
		Ok(views.html.register.userlogin("userlogin"))
	}
  def reg = Action { implicit request =>
		
		Ok(views.html.register.reg("welcome to registration page"))
	}
	def welcome = Action { implicit request =>
		
		Ok(views.html.register.welcome("HI user"))
	}
}
