package com.codingkapoor.tranlation

import akka.actor.Actor
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import com.codingkapoor.tranlation.TranslatorSupervisor.SayHello

object TranslatorSupervisor {

  case object SayHello

}

class TranslatorSupervisor extends Actor {
  implicit lazy val timeout: Timeout = Timeout(5.seconds)

  private val props = TranslatorPropsFactory.getTranslatorProps(java.util.Locale.getDefault)
  private val translator = context.actorOf(props)

  override def receive: Receive = {
    case SayHello =>
      val _sender = sender()

      val f = translator ? SayHello
      f.map { res =>
        _sender ! res
      }
  }
}
