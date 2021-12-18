//import scala.language.postfixOps
import scala.annotation.tailrec

val list1 = List("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
//task1
def functionTask1Ar1(days:List[String]):String={
  var result=""
  for(i <- 0 until days.length){
   result=result+days(i) + "," 
  }
  result  
}
def functionTask1ArIf1(days:List[String]):String={
  var result=""
  for(i <- 0 until days.length if days(i).startsWith("S")){
   result=result+days(i) + "," 
  }
  result  
}

def functionTask1ArWhile1(days:List[String]):String={
  var i=0
  var result=""
  while (i < days.length){
     result=result+days(i) + ","
     i=i+1
  }
  //println(result)
  result
}

println(functionTask1Ar1(list1))
println(functionTask1ArIf1(list1))
println(functionTask1ArWhile1(list1))

println("Task 2")
def functionTask2List1(days:List[String]):String={
  if (days.isEmpty)
  ""
  else days.head+", "+functionTask2List1(days.tail)
 
}


def functionTask2List2(days:List[String]):String={
  if (days.isEmpty)
  ""
  else  functionTask2List1(days.tail) +"," + days.head
 
}
println(functionTask2List1(list1))
println(functionTask2List2(list1))

println("Task 3")

def functionTask3(days:List[String]):String={
  
  @tailrec
  def iter(x:Int, result:String):String=
  if(x==days.length) result
  else iter(x+1,result+", "+days(x))
  iter(0,"")
}
println(functionTask3(list1))

println("Task 4")

def functionTask41(days:List[String]):String={
  var result=""
  var resultFinal=days.foldLeft(""){(prevValue,curValue)=> prevValue+", " +curValue}
  resultFinal
  
}
def functionTask42(days:List[String]):String={
  var result=""
  var resultFinal=days.foldRight(""){(prevValue,curValue)=> prevValue+", " +curValue}
  resultFinal
}

def functionTask43(days:List[String]):String={
  var result=""
  var resultFinal=days.foldRight("") {(prevValue,curValue)=> if (prevValue.startsWith("S"))  curValue+", " +prevValue else curValue }
  resultFinal
}
println(functionTask41(list1))
println(functionTask42(list1))
println(functionTask43(list1))

println("Task 5")

val products= Map("item1"->10,"item2"->228, "item3"->322,"item4"->666)
val redProducts= products.map((key,value) => value*0.9)
println(redProducts)

println("Task 6")
val intList=List(1,2,3,45,6,7,8,9,10)
def functionTask6(values:List[Int]):List[Int]={
  var reducedList= values.map(value=>value+1)
  reducedList
}
println(functionTask6(intList))

println("Task 7")
val realList=List(1.1,-2.4,-3.44,45.54,-60.54,-7.43,-88.88,-59.12,10.12)

def functionTask7(values:List[Double]):List[Double]={
  var reducedList= values.filter( (x) => x> -5 && x<12).map((x)=>x.abs)
  reducedList
}
println(functionTask7(realList))

println("Task 8")

val tuple3Type =(3.14,"WOWOWWw",'p')

def functionTask8(input:Tuple3[Any,Any,Any])={
  
  input.productIterator.foreach(x=>print(x.toString()+", "))
}
functionTask8(tuple3Type)

println("Task 9")
val intList2=List(1,0,3,0,6,0,8,0,10,0,0,12,0,0,0)

def functionTask9(input:List[Int]):List[Int]={
  @tailrec
  def iter(x:Int,result:List[Int]):List[Int]=
    if (input.isEmpty) input
    else if (x==input.length) result
    else if (input(x)==0)  iter(x+1,result)
    else iter(x+1,result:+input(x))
  iter(0,List[Int]())
}
println(functionTask9(intList2))

println("Task 10")

val intList3=List(Some(1),None,None,Some(4))
def functionTask10_1(input:List[Option[Int]])={
  for (i <- 0 until input.length){
    print(input(i).getOrElse(228) + ", ")
  }
}

def functionTask10_2(input:List[Option[Int]])={
  for (i <- 0 until input.length){
    if(input(i).isEmpty) print("Number is empty, ") else print(input(i).get +", ")
    
  }
}
functionTask10_1(intList3)
println()
functionTask10_2(intList3)