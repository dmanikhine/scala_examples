
object Main extends App { 
  import Conv._

  val expr:Expression=Plus(Number(1),Minus(Number(3),Number(2)))
  println(JsonWriter.write(expr))
    
}
