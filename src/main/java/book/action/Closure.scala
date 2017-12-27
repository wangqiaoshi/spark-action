package book.action

import org.apache.spark.sql.SparkSession

/**
  * Created by wqs on 17/12/24.
  */
object Closure {


  def main(args: Array[String]) {
    closure1
    println("-----------------")
    closure2
    println("-----------------")
    sparkCloure
  }

  def closure2(): Unit ={
    val fs = new Array[()=>Int](4)
    def set(i:Int) { fs(i) = () => i }
    var j = 0
    while(j < 4) {set(j); j=j+1}
    fs.foreach( f => println(f()))
  }


  def closure1(): Unit ={
    val fs = new Array[()=>Int](4)
    var i = 0
    while(i < 4)  { fs(i) = () => i; i=i+1}
    fs.foreach( f => println(f()))
  }

  def sparkCloure(): Unit ={

    val spark = SparkSession
      .builder()
      .master("local[1]")
      .appName("hello world")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    val rdd = spark.sparkContext.parallelize(Seq(1,3,4,5,6,99,8888))
    var counter = 0
    // 这是错误做法
    rdd.foreach(x => counter += x)

    println("Counter value: " + counter)
  }





}
