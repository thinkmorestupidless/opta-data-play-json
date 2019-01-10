organization in ThisBuild := "less.stupid"
version in ThisBuild := "1.0-SNAPSHOT"
scalaVersion in ThisBuild := "2.12.4"

lazy val playVersion = "2.6.9"
lazy val bijectionVersion = "0.9.6"

lazy val playJson = "com.typesafe.play" %% "play-json" % playVersion
lazy val bijection = "com.twitter" %% "bijection-avro" % bijectionVersion

lazy val sprayVersion = "10.1.6"
lazy val spray = "com.typesafe.akka" %% "akka-http-spray-json" % sprayVersion

lazy val `opta-data-schemae` = (project in file(".")).
  aggregate(`play-json`, `spray-json`, avro)

lazy val `play-json` = (project in file("play-json"))
  .settings(
    libraryDependencies ++= Seq(
      playJson
    )
  )

lazy val `spray-json` = (project in file("spray-json"))
  .settings(
    libraryDependencies ++= Seq(
      spray
    )
  )

lazy val avro = (project in file("avro"))
  .settings(
    libraryDependencies ++= Seq(
      bijection
    ),
    (sourceGenerators in Compile) += (avroScalaGenerateSpecific in Compile).taskValue,
  )

