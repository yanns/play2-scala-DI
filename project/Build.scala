import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "DI"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "org.springframework" % "spring-context" % "3.0.7.RELEASE"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // Add your own project settings here
    )

}
