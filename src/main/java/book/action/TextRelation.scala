package book.action

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.sources.{BaseRelation, TableScan}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SQLContext}

/**
  * Created by wqs on 18/1/14.
  */

class TextRelation(override val sqlContext: SQLContext) extends  BaseRelation with TableScan {

  override def schema: StructType = {
    StructType(
      Seq(StructField("name",StringType),
        StructField("age",IntegerType),
        StructField("sex",StringType))
    )
  }

  override def buildScan(): RDD[Row] = {
    val sc = sqlContext.sparkContext
    sc.parallelize(Seq(
      ("zhangsan",19,"women"),
      ("lisi",25,"women"),
      ("wangwu",20,"man"),
      ("mazi",50,"man")
    )).map(line=>{
      Row.fromTuple(line)
    })
  }
}
