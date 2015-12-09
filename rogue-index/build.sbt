libraryDependencies <++= (scalaVersion) { scalaVersion =>
  def sv(s: String) = s + "_" + (scalaVersion match {
      case s if (s.startsWith("2.10")) => "2.10"
      case s if (s.startsWith("2.11")) => "2.11"
      case v => v
  })
  Seq(
    "com.foursquare"           % sv("rogue-field")     % "2.2.2"      % "compile"
  )
}

Seq(RogueBuild.defaultSettings: _*)
