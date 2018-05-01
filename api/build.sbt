version := "0.1"

scalaVersion := "2.12.5"


libraryDependencies ++= Seq(
  "org.scalatest"     %%  "scalatest"  % "3.0.1"  % "test",
  "com.typesafe.akka" %% "akka-http"   % "10.1.1",
  "com.typesafe.akka" %% "akka-stream" % "2.5.11",
  "io.spray" %%  "spray-json" % "1.3.3",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.1",
  "com.typesafe" % "config" % "1.3.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"
)

mainClass in (Compile, run) := Some("com.inaranirattisai.WebServer")
