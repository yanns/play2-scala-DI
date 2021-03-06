package models.implicitinject

import play.api.libs.json.JsValue
import java.net.URLEncoder
import play.api.libs.ws.WS
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import models.{BERequest, BERequestConfiguration}
import concurrent.Future

class WikipediaRequest(implicit requestConfiguration: BERequestConfiguration) extends BERequest {
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
