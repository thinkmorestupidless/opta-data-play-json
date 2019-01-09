organization in ThisBuild := "less.stupid"
version in ThisBuild := "1.0-SNAPSHOT"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.12.4"

lazy val playVersion = "2.6.9"
lazy val playJson = "com.typesafe.play" %% "play-json" % playVersion

lazy val `opta-data-play-json` = (project in file(".")).
  aggregate(`play-json`)

lazy val `play-json` = (project in file("play-json"))
  .settings(
    libraryDependencies ++= Seq(
      playJson
    )
  )

