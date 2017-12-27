package book.action

import org.apache.spark.sql.SparkSession

/**
  * Created by wqs on 17/12/24.
  */
object HelloWorld {

  def main(args: Array[String]) {

    val spark = SparkSession
      .builder()
      .master("local[2]")
      .appName("hello world")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    import spark.implicits._

    val peopleDF = spark.read.json("src/main/resources/people.json")

    val newPeopleDF = peopleDF.map(row=>{
      val name = row.getAs[String]("name")
      val age = row.getAs[Long]("age")
      (name,age-18)
    }).toDF("name","理黄花大闺女的年龄差")

    newPeopleDF.show()




  }

}
