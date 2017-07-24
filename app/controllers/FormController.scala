package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */

case class UserData(name:String,age:Int)

@Singleton
class FormController @Inject() extends Controller {

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */

  val userForm = Form {
    mapping(
      "name" -> text,
      "age" -> number
    )(UserData.apply)(UserData.unapply)
  }

  val anyData = Map("name" -> "sandeep","age" -> "22")
  val userData = userForm.bind(anyData).get

  val userPost = Action(parse.form(userForm)) { implicit request =>
    val userData = request.body
    val newUser = models.User(userData.name,userData.age)
    val id = models.User.create(newUser)
    Redirect(routes.FormController.home(id))
  }

}