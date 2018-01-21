from pyspark.sql import SparkSession

spark = SparkSession \
        .builder \
        .appName("Python Spark SQL Hive integration example") \
        .enableHiveSupport() \
        .getOrCreate()

spark.sql("CREATE TABLE IF NOT EXISTS user (userid int, name string)")
spark.sql("LOAD DATA LOCAL INPATH 'src/main/resources/user.txt' INTO TABLE user")

userSparkDF = spark.sql("select * from user")


userPandasDF = userSparkDF.toPandas()

print userPandasDF

spark.stop()