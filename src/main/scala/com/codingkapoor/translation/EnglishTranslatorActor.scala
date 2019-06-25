package com.codingkapoor.tranlation

import akka.actor.Actor
import com.codingkapoor.tranlation.TranslatorSupervisor.SayHello

object EnglishTranslatorActor {

  case object SayHello

}

class EnglishTranslatorActor extends Actor {
  override def receive: Receive = {
    case SayHello => sender ! "Hello"
  }
}
