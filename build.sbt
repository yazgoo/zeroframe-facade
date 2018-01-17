import org.scalajs.core.tools.linker.standard._
enablePlugins(ScalaJSPlugin)

scalaJSUseMainModuleInitializer := true
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
ensimeScalaVersion in ThisBuild := "2.12.2"
scalaJSLinkerConfig ~= { _.withOutputMode(OutputMode.ECMAScript2015) }
name := "ZeroFrame facade"
normalizedName := "zeroframe-facade"
organization := "org.yazgoo"

version := "0.0.1"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1"
)
