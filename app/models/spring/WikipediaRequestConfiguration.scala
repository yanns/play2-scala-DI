package models.spring

import models.BERequestConfiguration

@org.springframework.stereotype.Service
class WikipediaRequestConfiguration extends BERequestConfiguration {

  def url = "http://en.wikipedia.org/w/api.php?format=json&action=query&titles=%s"

  def userAgent = "MyDI/1.0"

}

