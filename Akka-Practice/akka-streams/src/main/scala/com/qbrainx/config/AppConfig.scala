package com.qbrainx.config

import com.typesafe.config.ConfigFactory

object AppConfig {

  val config=ConfigFactory.load().getConfig("akka-stream-application")
}
