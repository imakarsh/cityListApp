package com.imply.evaluate

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.sum

object CityListApp extends App {

  val spark = SparkSession.builder
    .appName("City List Update")
    .master("local")
    .getOrCreate()

  val csvCityList = spark.read.option("header", "true").csv("src/main/resources/DataSets/CityList.csv")

  val jsonCityList = spark.read.json("src/main/resources/DataSets/CityListA.json")

  val avroCityList = spark.read.format("com.databricks.spark.avro").load("src/main/resources/DataSets/CityListB.avro")

  val cityList = csvCityList.union(jsonCityList).union(avroCityList).dropDuplicates()

  val maxPopulation = cityList.select("Population").orderBy("Population").first().get(0)

  val cities = cityList.filter("Population = " + maxPopulation).select("Name").collect()
  val cityNames = cities.map(r => r.getString(0))

  val BrazilPopulation = cityList.selectExpr("cast(Population as int) Population", "CountryCode").filter("CountryCode == 'BRA'").groupBy("CountryCode").agg(sum("Population").as("pop")).select("pop").first().getLong(0)

  println("Total rows : " + cityList.count())
  println("Max Population in a City is : " + maxPopulation)
  println("List of cities with max population are : " + cityNames.reduce((x, y) => x + ", " + y))
  println("Population in Brazil is : " + BrazilPopulation)

}
