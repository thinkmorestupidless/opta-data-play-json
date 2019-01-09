organization in ThisBuild := "less.stupid"
version in ThisBuild := "1.0-SNAPSHOT"
scalaVersion in ThisBuild := "2.12.4"

lazy val playVersion = "2.6.9"
lazy val bijectionVersion = "0.9.6"

lazy val playJson = "com.typesafe.play" %% "play-json" % playVersion
lazy val bijection = "com.twitter" %% "bijection-avro" % bijectionVersion

lazy val `opta-data-schemae` = (project in file(".")).
  aggregate(`play-json`, avro)

lazy val `play-json` = (project in file("play-json"))
  .settings(
    libraryDependencies ++= Seq(
      playJson
    )
  )

lazy val avro = (project in file("avro"))
  .settings(
    libraryDependencies ++= Seq(
      bijection
    ),
    (sourceGenerators in Compile) += (avroScalaGenerateSpecific in Compile).taskValue,
  )

