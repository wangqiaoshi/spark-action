package book.action

/**
  * Created by wqs on 17/12/26.
  */
object IteratorL {

  def main(args: Array[String]) {

    val it =  Iterator[String]("name1","name2","name3")

    def rename(name:String): String  ={
      println(name)
      name+"1"
    }

    val it2  = it.map(name=>rename(name))
    it2.foreach(name=>{
      println(name)
    })

  }


}
