version := "0.1"

scalaVersion := "2.12.5"

libraryDependencies ++= Seq(
  "org.scalatest"     %%  "scalatest"  % "3.0.1"  % "test",
  "com.typesafe.akka" %% "akka-http"   % "10.1.1",
  "com.typesafe.akka" %% "akka-stream" % "2.5.11",
  "com.typesafe" % "config" % "1.3.2"
)

mainClass in (Compile, run) := Some("com.inaranirattisai.WebServer")
