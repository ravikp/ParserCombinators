name := "ParserCombinatorSeed"

version := "1.0"

scalaVersion := "2.11.7"

organization := "com.ravi"

//Development dependencies
val parsercombinator = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3"

//Test dependencies
val scalatest = "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

// add scala-xml dependency when needed (for Scala 2.11 and newer) in a robust way
// this mechanism supports cross-version publishing
libraryDependencies ++= Seq(parsercombinator, scalatest)
