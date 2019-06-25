package com.codingkapoor.tranlation

import akka.actor.Actor
import com.codingkapoor.tranlation.TranslatorSupervisor.SayHello

object DutchTranslatorActor {

  case object SayHello

}

class DutchTranslatorActor extends Actor {
  override def receive: Receive = {
    case SayHello => sender ! "Hallo"
  }
}
