package book.action

/**
  * Created by wqs on 17/12/27.
  */
object Implicit {

  def main(args: Array[String]) {

    val people = new People
    people.eat()

  }

}


class People{

  var state:String = "walking"

  def doSomething(): Unit ={
    println(s"i'm $state")
  }

}

class PeopleFunction(people: People){

  def eat(): Unit ={
    people.state = "eating"
    people.doSomething()
  }

}


