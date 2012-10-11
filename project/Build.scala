import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "holdYourHorses2"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "commons-io" % "commons-io" % "2.4",
      "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
      "com.typesafe.akka" % "akka-testkit" % "2.0.2" % "test",      
      "org.mockito" % "mockito-all" % "1.9.0" % "test"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      ebeanEnabled:=true
      // Add your own project settings here      
    )

}
