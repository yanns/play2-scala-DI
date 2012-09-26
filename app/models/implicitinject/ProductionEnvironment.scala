package models.implicitinject

import models.{BERequestConfiguration, BERequest}

object ProductionEnvironment {

  implicit val requestConfiguration: BERequestConfiguration = new WikipediaRequestConfiguration
  implicit val request: BERequest = new WikipediaRequest

}
