package controllers.cake

import org.specs2.mutable._
import play.api.test.Helpers._
import play.api.test._
import models.cake.RequestComponent
import play.api.libs.concurrent.Promise
import play.api.libs.json.Json._
import play.api.mvc.{AsyncResult, Result}

trait MockRequestComponent extends RequestComponent {

  def request = new MockRequest

  class MockRequest extends models.Request {
    def get(title: String) = {
      Promise.pure(
        toJson (
          Map("title" -> title)
        )
      )
    }
  }
}

// inject MockRequestComponent into controller
object ApplicationTest extends controllers.cake.ApplicationImpl with MockRequestComponent


class ApplicationSpec extends Specification {

  "Cake Pattern" should {
    "inject custom json" in {
      running(FakeApplication()) {

        val result = getResult( ApplicationTest.index(FakeRequest()) )
        status(result) must equalTo(OK)
        contentAsString(result) must equalTo("""{"title":"Representational state transfer"}""")
      }
    }
  }

  /**
   * for asynchronous result, wait for end result
   */
  def getResult(result: Result): Result = result match {
    case ar: AsyncResult => ar.result.await.get
    case r => r
  }

}
