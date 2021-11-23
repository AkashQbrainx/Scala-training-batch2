
import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow, Keep, RunnableGraph, Sink, Source}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object FlowExample extends App{
  implicit val system: ActorSystem =ActorSystem("myActor")
  implicit val mat=ActorMaterializer
   val flow: Flow[Int, Int, NotUsed] =Flow[Int].map(_*2).map(_+10)
 // Source(1 to 5).via(flow).runForeach(f=>println(f))

  val source: Source[Int, NotUsed] =Source(1 to 5)

  val sink: Sink[Int, Future[Done]] =Sink.foreach(f=>println(f))

  val done: RunnableGraph[Future[Done]] = source.via(flow).toMat(sink)(Keep.right)

  done.run()
//  source.via(flow).runWith(sink).onComplete{
//    case Success(value)=>println(value)
//    case Failure(exception)=>println(exception.getMessage)
//  }




}
