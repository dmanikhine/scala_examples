

object Main extends App { 
type Par[A] = Int => List[A]

 def foo(a: => Int):Int=>Unit = 
 num => { println(a+a+num)}

def test=foo({ println("hi"); 1+24 })
println("Start test")
test(50)
      
}
