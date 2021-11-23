import akka.actor.ActorSystem
import akka.stream.scaladsl.Source
import scala.concurrent.ExecutionContext.Implicits.global
object exception extends App{
  implicit val system=ActorSystem()
  val iterator = new Iterator[Int] {

    private[this] var i = -1

    override def hasNext: Boolean = true

    override def next(): Int = {
      if (i % 2 == 0) {
        throw new Exception("Even Number")
      } else {
        i += 1
        i
      }
    }
  }
  Source.fromIterator(() => iterator)
    .recover {
      case ex: Exception =>
        println(ex.getMessage)
    }.runForeach(f => println(f.toString))
    .onComplete(f => println(f.toString))
}
