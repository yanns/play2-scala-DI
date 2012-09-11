package controllers.cake

import play.api.mvc._
import models.cake._

// "inject" the implementation to use the wikipedia API
object Application extends ApplicationImpl
                      with WikipediaRequestConfigurationComponent
                      with WikipediaRequestComponent

// implementation of Application is in a trait so that we can
// inject other dependencies for testing
trait ApplicationImpl extends Controller with RequestComponent {

  def index = Action {
    Async {
      request.get("Representational state transfer")
      .map{ response => Ok(response) }
    }
  }

}
