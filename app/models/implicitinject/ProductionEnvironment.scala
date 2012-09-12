package models.implicitinject

import models.{BERequestConfiguration, BERequest}

object ProductionEnvironment {

  implicit val request: BERequest = new WikipediaRequest
  implicit val requestConfiguration: BERequestConfiguration = new WikipediaRequestConfiguration

}
