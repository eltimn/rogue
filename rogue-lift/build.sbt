Seq(RogueBuild.defaultSettings: _*)

name <<= (name, liftEdition) { (n, e) =>  n + "_" + e }

libraryDependencies ++= Seq(
  "net.liftweb"     %% "lift-util"           % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"     %% "lift-common"         % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"     %% "lift-record"         % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"     %% "lift-mongodb-record" % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"     %% "lift-mongodb"        % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"     %% "lift-webkit"         % liftVersion.value  % "compile" intransitive(),
  "net.liftweb"     %% "lift-json"           % liftVersion.value  % "compile",
  "joda-time"        % "joda-time"           % "2.9.2"            % "compile",
  "org.joda"         % "joda-convert"        % "1.8.1"            % "compile",
  "org.mongodb"      % "mongo-java-driver"   % "2.14.1"           % "compile"
)

// Necessary beginning with sbt 0.13, otherwise Lift editions get messed up.
// E.g. "2.5" gets converted to "2-5"
moduleName := name.value
