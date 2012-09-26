package models

import play.api.libs.json.JsValue
import concurrent.Future

trait BERequest {

  /**
   * @param title title of the page
   * @return JSon from [[http://www.mediawiki.org/wiki/API Wikipedia API]]
   */
  def get(title: String): Future[JsValue]

}
