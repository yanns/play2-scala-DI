package models

import play.api.libs.concurrent.Promise
import play.api.libs.json.JsValue

trait BERequest {

  /**
   * @param title title of the page
   * @return JSon from [[http://www.mediawiki.org/wiki/API Wikipedia API]]
   */
  def get(title: String): Promise[JsValue]

}
