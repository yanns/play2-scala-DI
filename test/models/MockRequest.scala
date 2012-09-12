package models

import play.api.libs.concurrent.Promise
import play.api.libs.json.Json._

class MockRequest extends models.BERequest {
  def get(title: String) = {
    Promise.pure(
      toJson(
        Map("title" -> title)
      )
    )
  }

}
