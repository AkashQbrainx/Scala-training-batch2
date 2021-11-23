//import akka.Done
//import akka.actor.typed.ActorSystem
//import akka.actor.typed.scaladsl.Behaviors
//import akka.http.scaladsl.Http
//import akka.http.scaladsl.model.{StatusCodes, Uri}
//import akka.http.scaladsl.server.Directives.{as, complete, concat, entity, get, onSuccess, path, pathPrefix, post}
//import akka.http.scaladsl.server.PathMatchers.LongNumber
//import akka.http.scaladsl.server.Route
//import spray.json.DefaultJsonProtocol._
//
//import scala.concurrent.Future
//
//object SprayJsonExample {
//
//  // needed to run the route
//  implicit val system = ActorSystem(Behaviors.empty, "SprayExample")
//  // needed for the future map/flatmap in the end and future in fetchItem and saveOrder
//  implicit val executionContext = system.executionContext
//
//  var orders: List[Item] = Nil
//
//  // domain model
//  final case class Item(name: String, id: Long)
//
//  final case class Order(items: List[Item])
//
//  // formats for unmarshalling and marshalling
//  implicit val itemFormat = jsonFormat2(Item)
//  implicit val orderFormat = jsonFormat1(Order)
//
//  // (fake) async database query api
//  def fetchItem(itemId: Long): Future[Option[Item]] = Future {
//    orders.find(o => o.id == itemId)
//  }
//
//  def saveOrder(order: Order): Future[Done] = {
//    orders = order match {
//      case Order(items) => items ::: orders
//      case _ => orders
//    }
//    Future {
//      Done
//    }
//  }
//
//  def main(args: Array[String]): Unit = {
//    val route: Route =
//        post {
//          path("create-order") {
//            entity(as[Order]) { order =>
//              val saved: Future[Done] = saveOrder(order)
//              onSuccess(saved) { _ => // we are not interested in the result value `Done` but only in the fact that it was successful
//                complete("order created")
//              }
//            }
//          }
//
//      )
//
//    val bindingFuture = Http().newServerAt("localhost", 8080).bind(route)
//    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
//  }