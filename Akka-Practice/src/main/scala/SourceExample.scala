
import akka.actor.ActorSystem
import akka.stream.scaladsl.Source
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object SourceExample extends App {

 implicit val system: ActorSystem =ActorSystem("myActor")
  Source(1 to 10).runForeach(f=>println(f))
    .onComplete{
     case Success(value)=>println(s"Hi -${value.toString}")
     case Failure(exception)=>exception.getMessage
    }

 // Source(List(1,2,3,4,5,6)).runForeach(f=>println(f))

}
