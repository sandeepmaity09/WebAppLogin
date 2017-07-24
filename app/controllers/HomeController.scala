package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def hello = Action {
    Ok("Hello World")
  }

  def gotRequest = Action { implicit request =>
    Ok("Got Request [" + request + "]")
  }

  def myName(name:String,sname:String) = Action {
    Ok("Hello " + name + " " + sname)
  }

  def dynamicName(name:String) = Action {
    Ok("Hello " + name)
  }

  def regexName(id:String) = Action {
    val num = id.length + 34
    Ok(num.toString)
  }

/*  def show(page:String) = Action {
    Result {
      loadContentFromDatabase(page).map { htmlContent =>
        Ok(htmlContent).as("text/html")
      }.getOrElse(NotFound)
    }
  }*/

/*  def show(id:Long) = Action {
    Client.findById(id).map { client =>
      Ok(views.html.Clients.display(client))
    }.getOrElse(NotFound)
  }*/

}
