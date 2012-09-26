package models.spring

import play.api.libs.json.JsValue
import java.net.URLEncoder
import play.api.libs.ws.WS
import models.{BERequest, BERequestConfiguration}
import concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import org.springframework.beans.factory.annotation.Autowired

@org.springframework.stereotype.Service
class WikipediaRequest extends BERequest {

  @Autowired
  val requestConfiguration: BERequestConfiguration = null

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
