package com.qbrainx.service.route

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.qbrainx.model.MailDetails
import spray.json.DefaultJsonProtocol._
import scala.concurrent.ExecutionContextExecutor

class EmailRoute {

  implicit val system: ActorSystem[Nothing] =ActorSystem(Behaviors.empty,"MyActor")
  implicit val executionContext: ExecutionContextExecutor =system.executionContext

  def route:Route={

  post{
    path("json"){
      entity(as[MailDetails])
  }
}
  }

}
