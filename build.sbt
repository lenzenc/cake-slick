name := "cake-slick"

version := "0.0.1"

scalaVersion := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases"
)


libraryDependencies ++= Seq(
  "com.typesafe.slick" % "slick_2.10" % "2.0.2",
  "com.typesafe" %% "scalalogging-slf4j" % "1.0.1",
  "com.typesafe"%"config"%"1.2.1",
  "org.slf4j" % "slf4j-api" % "1.7.1",
  "org.slf4j" % "log4j-over-slf4j" % "1.7.1",
  "org.slf4j" % "slf4j-simple" % "1.7.7",
  "mysql"%"mysql-connector-java"%"5.1.29",
  "com.h2database" % "h2" % "1.4.178"
)

Revolver.settings
