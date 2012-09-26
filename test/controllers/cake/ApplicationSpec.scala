package controllers.cake

import org.specs2.mutable._
import play.api.test.Helpers._
import play.api.test._

import models.cake.BERequestComponent

import models.MockRequest

trait MockRequestComponent extends BERequestComponent {

  def request = new MockRequest

}

// inject MockRequestComponent into controller
object ApplicationTest extends controllers.cake.ApplicationImpl with MockRequestComponent


class ApplicationSpec extends Specification {

  "Cake Pattern" should {
    "inject custom json" in {
      running(FakeApplication()) {

        val result = ApplicationTest.index(FakeRequest())
        status(result) must equalTo(OK)
        contentAsString(result) must equalTo("""{"title":"Representational state transfer"}""")
      }
    }
  }

}
