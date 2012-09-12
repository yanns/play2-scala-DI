package models.cake

import models.BERequestConfiguration

/**
 * provides an implementation for [[models.BERequestConfiguration]]
 */
trait WikipediaRequestConfigurationComponent extends BERequestConfigurationComponent {

  def requestConfiguration = new WikipediaRequestConfiguration

  class WikipediaRequestConfiguration extends BERequestConfiguration {
    def url = "http://en.wikipedia.org/w/api.php?format=json&action=query&titles=%s"

    def userAgent = "MyDI/1.0"
  }

}
