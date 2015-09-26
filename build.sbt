import sbt._
import Keys._

scalaVersion := "2.11.5"

lazy val root = Project(id = "reports-ai",
                        base = file(".")).aggregate(core)

lazy val core = Project(id = "core",
                       base = file("core")).dependsOn(macros)

lazy val macros = Project(id = "macros",
                          base = file("macros"))


