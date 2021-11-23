package practice

import akka.actor.ActorSystem
import akka.stream.scaladsl.Source
import scala.concurrent.ExecutionContext.Implicits.global

object Main2 extends App {
  implicit val syst=ActorSystem()
  val iterator = new Iterator[Int]{

    private[this] var a= 3
    override def hasNext: Boolean = true

    override def next(): Int = {
    if(a%2==0){
      throw new Exception("Even number")
    }
      else {
      a+=1
      a
    }
    }
  }

  val source=Source.fromIterator(()=>iterator)
  source
    .recoverWithRetries(4,{
      case ex:Exception=>
         println(ex.getMessage)
        Source.fromIterator(() => iterator)
    }).runForeach(f=>println(f.toString))
    .onComplete(f=>println(f.toString))

}
