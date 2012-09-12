package models.implicitinject

import play.api.libs.concurrent.Promise
import play.api.libs.json.JsValue
import java.net.URLEncoder
import play.api.libs.ws.WS
import models.{BERequest, BERequestConfiguration}

class WikipediaRequest(implicit requestConfiguration: BERequestConfiguration) extends BERequest {
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
