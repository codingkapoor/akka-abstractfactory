package com.codingkapoor.tranlation

import java.util.Locale
import akka.actor.Props

object TranslatorPropsFactory {
  def getTranslatorProps(locale: Locale): Props = {
    locale.getLanguage match {
      case "en" => Props[EnglishTranslatorActor]
      case "nl" => Props[DutchTranslatorActor]
    }
  }
}
