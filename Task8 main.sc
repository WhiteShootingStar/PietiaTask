val week = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

// Task1
def PatternMatching(day: String): String ={
var weekSmall = week.map(day=> day.toLowerCase())
day.toLowerCase() match {
    case x if (x.startsWith("s") && weekSmall.contains(x)) => "weekend"
    case x if (!x.startsWith("s") && weekSmall.contains(x))=>"work"
    case _ => "no such day"
  }
}
  println(PatternMatching("moNday"))
  println(PatternMatching("Sunday"))
  println(PatternMatching("Pietia"))

//Task2
class BankAccount( private var balance: Double) {
  def this()={
    this(0)
  }
  
  def deposit(amount: Double) = {
      if (amount > 0)
        balance = balance+amount
    }
    def withdraw(amount: Double) = {
      if (balance-amount>=0) {
        balance =balance- amount
      } else println("Not enought money")
    }
   def _balance=balance
}

val account = new BankAccount(228)
account.deposit(322)
println(account._balance)
account.withdraw(228)
println(account._balance)
val account1=new BankAccount()
println(account1._balance)

//Task 3
case class Person (firstName: String, lastName: String) {
  
  def hello (person:Person) = person match{
    case Person("Big", "Boss")=> println("Welcome Home Boss")
    case Person(_,"Kojima") =>println("KOJIMA IS GOD")
    case Person ("Edek",_)=> println("Edek luchshij prepod")
    case _ => println ("Privet Jopa")
  }
}
val p1 = new Person("Big","Boss")
val p2 = new Person("Fired","Kojima")
val p3 = new Person("Edek","Glow")
val p4 = new Person("Hohl","schwein")
p1.hello(p2)
p2.hello(p1)
p3.hello(p4)
p4.hello(p3)

//Task4
def TripleFunction(func: Int => Int, x: Int): Int = func(func(func(x)))
println(TripleFunction(x => Math.pow(x,2).toInt, 2))


//Task5

abstract class Person5 (private var _first_name:String, private var _last_name:String, private var _tax_to_pay :Int) {
  def first_name:String=_first_name
  def last_name:String=_last_name
  def tax_to_pay:Int=_tax_to_pay
  
}

trait  Employee extends Person5 {
  var _salary:Int=3000
  def salary:Int = _salary
  def set_salary(sal:Int)={
    _salary=sal
  }
  override def tax_to_pay:Int= (_salary*0.2).toInt
}


trait Student extends Person5{
    override def tax_to_pay: Int = 0
}

trait Teacher extends Employee {
    override def tax_to_pay: Int = (0.1 * salary).toInt
}

var student = new Person5("Sanya", "Sidl", 9000) with Student
println("Student")
println("Name: " + student.first_name)
println("Surname: " + student.last_name)
println("taxToPay: " + student.tax_to_pay)  

var emp = new Person5("Sanya", "Sidl", 9000) with Employee
println("Employee")
println("Name: " + emp.first_name)
println("Surname: " + emp.last_name)
println("taxToPay: " + emp.tax_to_pay)  

var teach = new Person5("Sanya", "Sidl", 9000) with Teacher
println("Teacher")
println("Name: " + teach.first_name)
println("Surname: " + teach.last_name)
println("taxToPay: " + teach.tax_to_pay)

var sw = new Person5("Sanya", "Sidl", 9000) with Student with Employee
print("Sudent worker")
println("taxToPay: " + sw.tax_to_pay)

var ws = new Person5("Sanya", "Sidl", 9000) with Employee with Student
print("Worker student")
println("taxToPay: " + ws.tax_to_pay)