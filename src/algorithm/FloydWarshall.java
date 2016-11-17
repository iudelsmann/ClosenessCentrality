package algorithm;

import java.util.Arrays;

import models.Graph;

public abstract class FloydWarshall {

  public static double[][] calculate(Graph g) {
    final double[][] distances;
    distances = Arrays.copyOf(g.getAdjacencyMatrix(), g.getSize());

    for (int k = 0; k < g.getSize(); k++) {
      for (int i = 0; i < g.getSize(); i++) {
        for (int j = 0; j < g.getSize(); j++) {
          distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
        }
      }
    }

    return distances;
  }

}
