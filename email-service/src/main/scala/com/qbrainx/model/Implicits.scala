package com.qbrainx.model
import spray.json.DefaultJsonProtocol._
import spray.json.RootJsonFormat

object Implicits {
  implicit val rootJsonFormat: RootJsonFormat[Mail] =jsonFormat5(Mail)
}
