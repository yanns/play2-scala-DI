import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import play.api.{Logger, PlayException, Application, GlobalSettings}

object Global extends GlobalSettings {

  var ctx: Option[ApplicationContext] = None

  override def onStart(app: Application) {
    ctx = Some(new ClassPathXmlApplicationContext("components.xml"))
  }

  override def getControllerInstance[A](controllerClass: Class[A]) = {
    ctx.map(_.getBean(controllerClass)).getOrElse( throw new PlayException("Spring context not initialized", "Spring context not initialized"))
  }

}
