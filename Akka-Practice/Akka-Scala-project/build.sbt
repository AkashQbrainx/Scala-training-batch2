import Dependencies._


name := "Akka-Scala-project"

version := "0.1"

scalaVersion := "2.13.6"

libraryDependencies ++= Akka.all ++ Slf4j.all

startYear := Some(2021)

description := "Historical Weather Service"