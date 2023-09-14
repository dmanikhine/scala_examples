
import java.nio.file.{Paths, Files}
import scala.util.{Failure, Success}
import scala.concurrent.{Future,Await}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Func {
  def waitingForTestFile(testFileName:String):Future[Boolean]=Future{
      while (!(Files.exists(Paths.get(testFileName)))) {
        
      }
      true      
    }
}

object Main extends App { 

  val path1="/home/dma/Future/test1.txt"
  val path2="/home/dma/Future/test2.txt"

  val future1=Func.waitingForTestFile(path1)
  val future2=Func.waitingForTestFile(path2)
  val comb =for (_ <- future1; _ <- future2) yield "success"

  println(Await.result(comb,Duration.Inf))
  
  println(comb.get())

      
}
