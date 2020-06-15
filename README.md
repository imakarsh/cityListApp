# cityListApp
This application solves a Coding exercise.

- The application is based out of Scala and Spark. It is built using Maven build tool.
- Use the [runbook](https://github.com/imakarsh/cityListApp/blob/master/runbook.md) to run the application
- The provided dataset is in the resource directory [here](https://github.com/imakarsh/cityListApp/tree/master/src/main/resources/DataSets)
- Answers to the questions

1. What is the count of all rows?
- 2083
2. What is the city with the largest population?
- GBR and Malita
3. What is the total population of all cities in Brazil (CountryCode == BRA)?
- 25117070
4. What changes could be made to improve your program's performance.
- The program has been made performant based on all possible things noticed.
5. How would you scale your solution to a much larger dataset (too large for a single machine to store)?
- Since this application is build using Spark framework, it can be scaled up using a Hadoop cluster. To run the application on a cluster, the run time parameters need to be set accordingly.
