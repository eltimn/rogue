Seq(RogueBuild.defaultSettings: _*)

liftVersion <<= liftVersion ?? "2.6.3"
liftEdition <<= liftVersion apply { _.substring(0,3) }
name <<= (name, liftEdition) { (n, e) =>  n + "_" + e }
crossScalaVersions <<= liftEdition { le => le match {
  case "3.0" => Seq("2.11.8")
  case _ => Seq("2.10.6", "2.11.8")
}}

libraryDependencies ++= Seq(
  "net.liftweb"    %% "lift-util"           % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"    %% "lift-actor"          % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"    %% "lift-common"         % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"    %% "lift-record"         % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"    %% "lift-mongodb-record" % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"    %% "lift-mongodb"        % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"    %% "lift-webkit"         % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"    %% "lift-json"           % liftVersion.value  % "compile",
  "joda-time"      % "joda-time"            % "2.9.2"            % "compile",
  "org.joda"       % "joda-convert"         % "1.8.1"            % "compile",
  "org.slf4j"      % "slf4j-api"            % "1.7.2"            % "test"
)

// Necessary beginning with sbt 0.13, otherwise Lift editions get messed up.
// E.g. "2.5" gets converted to "2-5"
moduleName := name.value
