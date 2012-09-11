package models.cake

import play.api.libs.json.JsValue
import play.api.libs.ws.WS
import play.api.libs.concurrent.Promise
import models.Request
import java.net.URLEncoder

/**
 * real implementation for [[models.Request]]
 */
trait WikipediaRequestComponent extends RequestComponent {

  // dependency: WikipediaRequestComponent needs RequestConfiguration
  this: RequestConfigurationComponent =>

  def request = new WikipediaRequest

  class WikipediaRequest extends Request {

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

