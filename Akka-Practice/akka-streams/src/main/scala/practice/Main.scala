package practice

import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import akka.io.dns.RecordType.A
import akka.stream.{ClosedShape, Graph}
import akka.stream.scaladsl.{Broadcast, Flow, GraphDSL, Merge, RunnableGraph, Sink, Source, Zip, ZipWith}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Main extends App{

//    implicit val system: ActorSystem =ActorSystem()
// val graph: Graph[ClosedShape.type, Future[Int]] = GraphDSL.createGraph(Sink.fold[Int,Int](0)(_+_)){
//
//      implicit builder=>
//        sink=>
//      import GraphDSL.Implicits._
//
//      val source=Source(1 to 5)
//
//      val broadcast=builder.add(Broadcast[Int](2))
//      val zip=builder.add(ZipWith[Int,Int,Int]((a,b)=>a+b))
//
//     source ~> broadcast
//      broadcast.out(0)  ~>zip.in0
//      broadcast.out(1) ~> zip.in1
//
//      zip.out ~> sink
//     ClosedShape
//
//  }
//  RunnableGraph.fromGraph(graph).run().onComplete(f=>println(f))

}
