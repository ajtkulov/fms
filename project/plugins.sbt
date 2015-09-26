logLevel := Level.Warn

addSbtPlugin("com.github.mpeltonen" %% "sbt-idea" % "1.6.0")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.7.0")

addSbtPlugin("com.gu" %% "sbt-teamcity-test-reporting-plugin" % "1.5")

addSbtPlugin("net.virtual-void" %% "sbt-dependency-graph" % "0.7.4")

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("org.scoverage" %% "sbt-scoverage" % "0.99.7.1")

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

