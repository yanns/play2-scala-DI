package models.cake

import play.api.libs.json.JsValue
import play.api.libs.ws.WS
import play.api.libs.concurrent.Promise
import models.BERequest
import java.net.URLEncoder

/**
 * real implementation for [[models.BERequest]]
 */
trait WikipediaRequestComponent extends BERequestComponent {

  // dependency: WikipediaRequestComponent needs BERequestConfiguration
  this: BERequestConfigurationComponent =>

  def request = new WikipediaRequest

  class WikipediaRequest extends BERequest {

    def get(title: String): Promise[JsValue] = {
      val url = requestConfiguration.url.format( URLEncoder.encode(title, "UTF-8") )
      WS.url(url)
        .withHeaders("User-Agent" -> requestConfiguration.userAgent)
        .get()
        .map {
        _.json
      }
    }

  }

}

