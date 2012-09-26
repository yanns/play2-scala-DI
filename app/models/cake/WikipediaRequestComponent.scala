package models.cake

import play.api.libs.json.JsValue
import play.api.libs.ws.WS
import models.BERequest
import java.net.URLEncoder
import concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * real implementation for [[models.BERequest]]
 */
trait WikipediaRequestComponent extends BERequestComponent {

  // dependency: WikipediaRequestComponent needs BERequestConfiguration
  this: BERequestConfigurationComponent =>

  def request = new WikipediaRequest

  class WikipediaRequest extends BERequest {

    def get(title: String): Future[JsValue] = {
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

