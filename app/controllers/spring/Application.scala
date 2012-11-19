package controllers.spring

import play.api.mvc.{Action, Controller}
import play.api.libs.concurrent.Execution.Implicits._

import org.springframework.beans.factory.annotation._
import models.BERequest


@org.springframework.stereotype.Controller
class Application extends Controller {

  @Autowired
  var request: BERequest = null

  def index = Action {
    Async {
      request.get("Representational state transfer")
        .map{ response => Ok(response) }
    }
  }

}
