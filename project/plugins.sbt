addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "0.2.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-pgp" % "0.8.3")

scalacOptions ++= Seq("-deprecation", "-unchecked")

addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0")
