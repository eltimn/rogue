libraryDependencies <++= (scalaVersion) { scalaVersion =>
  val specsVersion = "3.7.2"
  def sv(s: String) = s + "_" + (scalaVersion match {
      case s if (s.startsWith("2.10")) => "2.10"
      case s if (s.startsWith("2.11")) => "2.11"
      case v => v
  })
  Seq(
    "com.foursquare"           % sv("rogue-field")     % "2.2.2"      % "compile",
    "joda-time"                % "joda-time"           % "2.9.2"      % "provided",
    "org.joda"                 % "joda-convert"        % "1.8.1"      % "provided",
    "org.mongodb"              % "mongo-java-driver"   % "2.14.1"     % "compile",
    "junit"                    % "junit"               % "4.5"        % "test",
    "com.novocode"             % "junit-interface"     % "0.6"        % "test",
    "ch.qos.logback"           % "logback-classic"     % "1.1.7"      % "provided",
    "org.specs2"              %% "specs2-core"         % specsVersion % "test",
    "org.specs2"              %% "specs2-junit"        % specsVersion % "test",
    "org.scala-lang"           % "scala-compiler"      % scalaVersion % "test")
}

Seq(RogueBuild.defaultSettings: _*)
