package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import algorithm.ClosenessCentrality;
import models.Graph;
import models.Pair;

public class MainClass {

  public static void main(String[] args) {

    // TODO dinamically get the number of vertexes
    final Graph g = new Graph(100, false);

    final Scanner scanner = new Scanner(System.in);

    // Reads until EOF or invalid token
    while (scanner.hasNextInt()) {
      int from = scanner.nextInt();
      int to = scanner.nextInt();
      g.addEdge(from, to, 1);
    }
    scanner.close();

    // Executes the closeness centrality algorithm
    Double[] result = ClosenessCentrality.calculate(g);

    // Builds pairs from the results, where index is the vertex number and the
    // value is the closeness of that vertex
    Pair[] pairs = new Pair[g.getSize()];
    for (int i = 0; i < g.getSize(); i++) {
      pairs[i] = new Pair(i, result[i]);
    }

    // Sort the pairs and print out both the vertex and its closeness
    Arrays.sort(pairs, Collections.reverseOrder());
    for (int i = 0; i < g.getSize(); i++) {
      System.out.format("%d %.10f\n", pairs[i].getIndex(), pairs[i].getValue());
    }
  }
}
