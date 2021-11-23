package practice

import akka.stream.scaladsl.Source

object Main4 extends App {

  Source(1 to 5)
    .map{
      f=>if(f==5) throw new Exception("Even number")
      else f
    }.recover{
    case ex:Exception=>println(ex.getMessage)
  }

}
