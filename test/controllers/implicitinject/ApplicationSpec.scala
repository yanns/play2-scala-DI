package controllers.implicitinject

import org.specs2.mutable._
import play.api.test.Helpers._
import play.api.test._

import models.{BERequest, MockRequest}
import controllers.ResultExtractor._


class ApplicationSpec extends Specification {

  val mockRequest: BERequest = new MockRequest

  object ApplicationTest extends controllers.implicitinject.ApplicationImpl()(mockRequest, null)

  "Injection with implicits" should {
    "inject custom json" in {
      running(FakeApplication()) {

        val result = getResult(ApplicationTest.index(FakeRequest()))
        status(result) must equalTo(OK)
        contentAsString(result) must equalTo( """{"title":"Representational state transfer"}""")
      }
    }
  }

}
