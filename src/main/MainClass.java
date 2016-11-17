package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import algorithm.ClosenessCentrality;
import models.Graph;
import models.Pair;

public class MainClass {

  public static void main(String[] args) {

    final Graph g = new Graph(100, false);

    final Scanner scanner = new Scanner(System.in);

    while (scanner.hasNextInt()) {
      int from = scanner.nextInt();
      int to = scanner.nextInt();
      g.addEdge(from, to, 1);
    }
    scanner.close();

    Double[] result = ClosenessCentrality.calculate(g);
    Pair[] pairs = new Pair[g.getSize()];
    for (int i = 0; i < g.getSize(); i++) {
      pairs[i] = new Pair(i, result[i]);
    }
    Arrays.sort(pairs, Collections.reverseOrder());
    for (int i = 0; i < g.getSize(); i++) {
      System.out.print(pairs[i].getIndex() + " ");
      System.out.println(pairs[i].getValue());
    }
  }
}
