package controllers.implicitinject

import play.api.mvc.{Action, Controller}
import models.{BERequestConfiguration, BERequest}
import scala.concurrent.ExecutionContext.Implicits.global
import models.implicitinject.ProductionEnvironment._

object Application extends ApplicationImpl

class ApplicationImpl(implicit request: BERequest, requestConfiguration: BERequestConfiguration) extends Controller {

  def index = Action {
    Async {
      request.get("Representational state transfer")
        .map{ response => Ok(response) }
    }
  }

}
