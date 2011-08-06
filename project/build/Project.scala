import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {

    val droolsCore = "org.drools" % "drools-core" % "5.2.0.Final"
    val droolsCompiler = "org.drools" % "drools-compiler" % "5.2.0.Final"
    val jaxbXjc = "com.sun.xml.bind" % "jaxb-xjc" % "2.2.4-1"
}