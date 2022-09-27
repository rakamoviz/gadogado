import Dependencies._

ThisBuild / scalaVersion     := "2.13.9"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

libraryDependencies ++= Seq(
  "com.github.ghostdogpr"         %% "caliban"                       % "2.0.1",
  "com.github.ghostdogpr"         %% "caliban-http4s"                % "2.0.1",
  "com.github.ghostdogpr"         %% "caliban-client"                % "2.0.1",
  "org.http4s"                    %% "http4s-blaze-server"           % "0.23.12",
  "com.softwaremill.sttp.client3" %% "async-http-client-backend-zio" % "3.7.2",
  "org.scalameta" %% "semanticdb-scalac_2.12.10" % "4.5.13"
)

lazy val root = (project in file("."))
  .settings(
    name := "gadogado",
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
