package book

/**
  * Created by wqs on 17/12/27.
  */
package object action {

  implicit def peopleImpl(people: People): PeopleFunction ={
    new PeopleFunction(people)
  }

}
