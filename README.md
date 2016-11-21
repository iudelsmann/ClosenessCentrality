#Closeness Centrality

##Requirements

To build and execute this program is necessary to have installed java version 8 and maven.

##Building the code

After cloning the repository access the project's root folder on a terminal. To build the project execute the following command:

```
mvn clean package
```

##Executing the code

The building command should generate a new "target" folder in the project's root directory. Access the folder and you should find a jar file named **ClosenessCentrality-0.0.1-SNAPSHOT-jar-with-dependencies.jar**.
To execute part 1, the closeness centrality program with a graph coming from a file, execute:

```
java -jar ClosenessCentrality-0.0.1-SNAPSHOT-jar-with-dependencies.jar 1 <pathToFile>
```

Replace the <pathToFile> to the path to the file containing the information about the graph. 
This should print on screen the vertex and their closeness centrality value ordered descending.

To execute the second part, the command should be:

```
java -jar ClosenessCentrality-0.0.1-SNAPSHOT-jar-with-dependencies.jar 1
```

**As this program is still a WIP the tokens in the code are expired and should be replaced every few hours. Tokens are access tokens that users provide a program given it access to their information. The required access are user_friends.

##Algorithm details

The closeness centrality problem is in a way an extension of the APSP (All Pairs Shortest Path), which is finding the shortest path from each pair of vertex in a graph. Thus we started solving the problem using Floyd-Warshall algorithm. This algorithm is very simple and in dense graphs, without negative cycles, is the best known algorithm. For sparse graphs or with negative cycles there are other algorithms that could be better, but there should not be negative cycles in a friendship relation, we considered Floyd-Warshall a safer approach.

After calculating the APSP whe only have to loop in each vertex and sum the distance to each other vertex, and then divide the number of vertex, minus 1, by this sum, (N-1)/sum.

This should give the closeness of each vertex, and the one with the highest values can be considered more influential.
