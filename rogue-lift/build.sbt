libraryDependencies <++= (scalaVersion) { scalaVersion =>
  val liftVersion = "2.6.3"
  def sv(s: String) = s + "_" + (scalaVersion match {
      case s if (s.startsWith("2.10")) => "2.10"
      case s if (s.startsWith("2.11")) => "2.11"
      case v => v
  })
  Seq(
    "net.liftweb"              % sv("lift-util")           % liftVersion  % "compile" intransitive(),
    "net.liftweb"              % sv("lift-actor")          % liftVersion  % "compile" intransitive(),
    "net.liftweb"              % sv("lift-common")         % liftVersion  % "compile" intransitive(),
    "net.liftweb"              % sv("lift-record")         % liftVersion  % "compile" intransitive(),
    "net.liftweb"              % sv("lift-mongodb-record") % liftVersion  % "compile" intransitive(),
    "net.liftweb"              % sv("lift-mongodb")        % liftVersion  % "compile" intransitive(),
    "net.liftweb"              % sv("lift-webkit")         % liftVersion  % "compile" intransitive(),
    "net.liftweb"              % sv("lift-json")           % liftVersion  % "compile",
    "joda-time"                % "joda-time"               % "2.9.2"      % "compile",
    "org.joda"                 % "joda-convert"            % "1.8.1"      % "compile",
    "org.slf4j"                % "slf4j-api"               % "1.7.2"      % "test")
}

Seq(RogueBuild.defaultSettings: _*)
