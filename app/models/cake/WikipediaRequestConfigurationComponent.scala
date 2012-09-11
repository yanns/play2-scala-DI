package models.cake

import models.RequestConfiguration

/**
 * provides an implementation for [[models.RequestConfiguration]]
 */
trait WikipediaRequestConfigurationComponent extends RequestConfigurationComponent {

  def requestConfiguration = new WikipediaRequestConfiguration

  class WikipediaRequestConfiguration extends RequestConfiguration {
    def url = "http://en.wikipedia.org/w/api.php?format=json&action=query&titles=%s"

    def userAgent = "MyDI/1.0"
  }

}
