## **City List Solution Runbook :**

This maven project creates a Simple Application using Apache Spark that can be run against a Hadoop Cluster. This projects runs on a local machine with Spark installed.
The project uses maven repository to resolve Spark depedencies. 

Prerequisites:
Ensure you have a Hadoop cluster or [setup](https://www.tutorialspoint.com/apache_spark/apache_spark_installation.htm) Spark on local. 

### Build the Application :

On your dev environment to build & package the application

>mvn clean package

One of the artifact this will produce is ../target/citysolution-1.0-SNAPSHOT.jar

Copy the jar to your Hadoop Cluster if you are running it on a cluster.

### Run the Application on Hadoop Cluster :

Go to your Hadoop cluster & ensure you have the Spark jar copied into the cluster.

>./bin/spark-submit --class com.imply.evaluate.CityListApp --master local citysolution-1.0-SNAPSHOT.jar

Running the spark-submit will produce an output similar to

```
Total rows : 2083
Max Population in a City is : 100000
List of cities with max population are : GBR, Malita
Population in Brazil is : 25117070
```
### Anticipated changes needed :

_The current input to the application is from the resource directory within the jar. When input changes, the external paths need to be parameterized for the application._ 