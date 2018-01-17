import org.scalajs.core.tools.linker.standard._
enablePlugins(ScalaJSPlugin)

scalaJSUseMainModuleInitializer := true
scalacOptions += "-P:scalajs:sjsDefinedByDefault"
ensimeScalaVersion in ThisBuild := "2.12.2"
scalaJSLinkerConfig ~= { _.withOutputMode(OutputMode.ECMAScript2015) }
name := "ZeroFrame facade"
normalizedName := "zeroframe-facade"
organization := "io.github.yazgoo"

version := "0.0.1"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1"
)

val projectPath =" yazgoo/zeroframe-facade"
val github = s"https://github.com/${projectPath}"
homepage := Some(url(github))

scmInfo := Some(
  ScmInfo(
    url(github),
    s"scm:git@github.com:${projectPath}.git"
  )
)

developers := List(
  Developer(
    id    = "Yazgoo",
    name  = "Yazgoo",
    email = "yazgoo@github.com",
    url   = url("http://yazgoo.github.io")
  )
)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false
