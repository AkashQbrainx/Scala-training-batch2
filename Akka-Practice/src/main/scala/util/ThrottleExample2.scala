package util

import akka.actor.ActorSystem
import akka.{Done, NotUsed}
import akka.stream.Attributes
import akka.stream.scaladsl.{Sink, Source}

import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import scala.concurrent.Future
import scala.concurrent.duration.FiniteDuration
import scala.concurrent.ExecutionContext.Implicits.global
object ThrottleExample2 extends App{
implicit val system=ActorSystem()
  val iterator = new Iterator[Int] {
    private[this] var i = -1

    override def hasNext: Boolean = true

    override def next(): Int = {
      i += 1
      i
    }
  }

  val atomicInteger = new AtomicInteger(1)

  val source: Source[Int, NotUsed] = Source.fromIterator(() => iterator)

  val sink: Sink[Int, Future[Done]] = Sink.foreach[Int](f => println(f.toString))

  source
    .throttle(1, FiniteDuration(1, TimeUnit.MICROSECONDS),n=>n*1000*1000)
    .log("Dur")
    .withAttributes(Attributes.logLevels(Attributes.logLevelInfo))
    .mapAsync(10)(f => Future {
      println(f.toString)
      f
    })
    .to(sink)
    .run()


}
