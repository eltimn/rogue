Seq(RogueBuild.defaultSettings: _*)

name <<= (name, liftEdition) { (n, e) =>  n + "_" + e }

libraryDependencies ++= {
  val specsVersion = scalaVersion.value match {
    case "2.11.8" => "2.4.2"
    case "2.12.2" => "3.3"
  }
  Seq(
    // "com.foursquare"    %% "rogue-field"         % "2.4.0"            % "compile",
    "net.liftweb"       %% "lift-mongodb"        % liftVersion.value  % "compile" intransitive(),
    "net.liftweb"       %% "lift-common"         % liftVersion.value  % "compile",
    "net.liftweb"       %% "lift-json"           % liftVersion.value  % "compile",
    "net.liftweb"       %% "lift-util"           % liftVersion.value  % "compile",
    "joda-time"          % "joda-time"           % "2.9.2"            % "provided",
    "org.joda"           % "joda-convert"        % "1.8.1"            % "provided",
    "org.mongodb"        % "mongo-java-driver"   % "2.14.1"           % "compile",
    "junit"              % "junit"               % "4.5"              % "test",
    "com.novocode"       % "junit-interface"     % "0.6"              % "test",
    "ch.qos.logback"     % "logback-classic"     % "1.1.7"            % "provided",
    // "org.specs2"        %% "specs2"              % specsVersion       % "test",
    "org.scala-lang"     % "scala-compiler"      % scalaVersion.value % "test"
  )
}

// Necessary beginning with sbt 0.13, otherwise Lift editions get messed up.
// E.g. "2.5" gets converted to "2-5"
moduleName := name.value
