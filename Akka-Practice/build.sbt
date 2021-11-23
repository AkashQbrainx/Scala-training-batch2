
name := "Akka-Practice"

version := "0.1"

scalaVersion := "2.13.6"
val AkkaVersion = "2.6.16"
val Slf4jVersion = "2.0.0-alpha5"

libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % "10.2.6",
  "org.slf4j" % "slf4j-log4j12" % Slf4jVersion)