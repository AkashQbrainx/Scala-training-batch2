package com.qbrainx.service

import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import akka.stream.scaladsl.{Broadcast, Flow, GraphDSL, RunnableGraph, Sink, Source, Zip, ZipWith}
import akka.stream.stage.{GraphStage, GraphStageLogic, OutHandler}
import akka.stream.{Attributes, ClosedShape, FanInShape2, Outlet, SourceShape}
import akka.actor.ActorSystem
import akka.stream.ClosedShape
import akka.stream.scaladsl.{Broadcast, Flow, GraphDSL, Keep, RunnableGraph, Sink, Source, Zip}
import com.qbrainx.service.InputSource

import scala.concurrent.Future
import scala.io.StdIn

class InputSource extends GraphStage[SourceShape[String]] {
  val out: Outlet[String] = Outlet("InputSource")
  override val shape: SourceShape[String] = SourceShape(out)

  override def createLogic(inheritedAttributes: Attributes): GraphStageLogic = new GraphStageLogic(shape) {
    var value: String = StdIn.readLine()
    setHandler(out, new OutHandler {
        override def onPull(): Unit = {
            println("value produced")
            push(out, value)
           value=StdIn.readLine()
        }
      })
    }


}
