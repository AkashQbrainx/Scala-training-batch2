import akka.actor.ActorSystem
import akka.stream.scaladsl.JavaFlowSupport.Sink
import akka.stream.scaladsl.Source

object AsyncBoundary extends App {

  implicit val system: ActorSystem =ActorSystem()

  Source(1 to 5)
    .map(_*2)
    .map({
      f=>println(s"map1-$f")
    f})
    .async
    .map(f=>f *f)
    .map({
    f=>println(s"map2-$f")
      f})
    .runForeach(f=>println(f))


}
