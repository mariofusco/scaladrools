package scaladrools.rules

import org.drools._
import org.drools.io.ResourceFactory
import org.drools.runtime._
import org.drools.builder._
import scaladrools.model.Temperature

object RuleRunner extends App {

  println("Creating Knowledge Session")

  val ksession = knowledgeSession("WeatherRules.drl")

  println("Creating and insertng Temperature")

  val shouldBeTooHot = Temperature(100)
  val shouldBeTooCold = Temperature(20)

  ksession.insert(shouldBeTooHot)
  ksession.insert(shouldBeTooCold)

  println("Firing all rules")

  ksession.fireAllRules()

  def knowledgeSession(fileName: String) : StatefulKnowledgeSession = {
    val kbuilder  = KnowledgeBuilderFactory.newKnowledgeBuilder()
    kbuilder.add(ResourceFactory.newClassPathResource(fileName), ResourceType.DRL)
    val kbase = KnowledgeBaseFactory.newKnowledgeBase()
    kbase.addKnowledgePackages(kbuilder.getKnowledgePackages())
    kbase.newStatefulKnowledgeSession()
  }
}