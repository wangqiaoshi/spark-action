import pandas as pd
from pyspark.sql import SparkSession


#pandas读取cvs,形成dataframe
userDF = pd.read_csv("src/main/resources/upload.csv")

#启动spark
spark = SparkSession \
        .builder \
        .appName("Python Spark SQL Hive integration example") \
        .enableHiveSupport() \
        .getOrCreate()

#spark读取pandas dataframe,形成spark dataframe
sparkDF = spark.createDataFrame(userDF)
sparkDF.show()
spark.stop()