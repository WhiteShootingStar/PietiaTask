//Task1
class Container[A](private var value:A){
  
  def getContent():A={
    value
  }
  def applyFunction[R](func:A=>R):R={
    func(value)
  }
}
var cont1= new Container[Int](322)
cont1.applyFunction[Unit](x=>println(x.toDouble* 321))

//Task2

trait Maybe[+A]{
  def applyFunction[R](func: A=>R):Maybe[R]
  def getOrElse[B>:A](parameter:B):B
  
}

class No extends Maybe[Nothing]{
  override def applyFunction[R](func: Nothing=>R):Maybe[R]=
    new No()
  override   def getOrElse[B>:Nothing](parameter:B):B = parameter
}

class Yes[A](var value:A) extends Maybe[A]{
  override def applyFunction[R](func: A=>R):Maybe[R]={
    new Yes(func(value))
  }
  override   def getOrElse[B>:A](parameter:B):B = value
}
var n1= new No()
var y1=   new Yes[Int](1467)

println("Is No obsect an instance of Maybe? " + n1.isInstanceOf[Maybe[_]])
println("Is Yes object an instance of Maybe? " + y1.isInstanceOf[Maybe[_]])

//Task3
println("Task3")
println(n1.applyFunction(x=>x))
println(y1.applyFunction(x=>x*5))
//Task4
println("Task4")
println(n1.getOrElse(228))
println(y1.getOrElse(228))