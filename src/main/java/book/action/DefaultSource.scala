package book.action

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources.{BaseRelation, DataSourceRegister, RelationProvider}

/**
  * Created by wqs on 18/1/14.
  */
class DefaultSource extends RelationProvider with DataSourceRegister  {
  override def createRelation(sqlContext: SQLContext, parameters: Map[String, String]): BaseRelation = {

    new TextRelation(sqlContext)


  }

  override def shortName(): String = "TextDemo"
}
