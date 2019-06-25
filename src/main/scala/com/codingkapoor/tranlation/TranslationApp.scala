package com.codingkapoor.tranlation

import akka.actor.{ActorRef, ActorSystem, Props}
import com.codingkapoor.tranlation.TranslatorSupervisor.SayHello
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object TranslationApp extends App {
  implicit lazy val timeout: Timeout = Timeout(5.seconds)

  val system: ActorSystem = ActorSystem()
  val supervisor: ActorRef = system.actorOf(Props[TranslatorSupervisor])

  val f = supervisor ? SayHello
  f.map { res =>
    println(res)
  }
}
