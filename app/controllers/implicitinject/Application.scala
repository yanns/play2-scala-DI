package controllers.implicitinject

import play.api.mvc.{Action, Controller}
import play.api.libs.concurrent.Execution.Implicits._

import models.{BERequestConfiguration, BERequest}
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
