package book.action

import org.apache.spark.sql.SparkSession

/**
  * Created by wqs on 18/1/14.
  */
object DataSource {


  def main(args: Array[String]) {

    val spark = SparkSession
      .builder()
      .master("local[2]")
      .appName("datasource")
      .getOrCreate()
    val df = spark.read.format("book.action").load()
    df.show()


  }

}
