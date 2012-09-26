package controllers.spring

import play.api.mvc.{Action, Controller}

import org.springframework.beans.factory.annotation._
import models.BERequest
import scala.concurrent.ExecutionContext.Implicits.global


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
