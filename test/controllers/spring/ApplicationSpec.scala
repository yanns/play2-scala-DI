package controllers.spring

import org.specs2.mutable._
import play.api.test.Helpers._
import play.api.test._

import models.{BERequest, MockRequest}


class ApplicationSpec extends Specification {

  "Injection with spring" should {
    "inject custom json" in {
      running(FakeApplication()) {

        val application = new controllers.spring.Application()
        application.request = new MockRequest
        val result = application.index(FakeRequest())
        status(result) must equalTo(OK)
        contentAsString(result) must equalTo( """{"title":"Representational state transfer"}""")
      }
    }
  }

}
