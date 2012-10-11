import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "holdYourHorses2"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "commons-io" % "commons-io" % "2.4",      
      "com.typesafe.akka" % "akka-testkit" % "2.0.2" % "test"      
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      ebeanEnabled:=true
      // Add your own project settings here      
    )

}
