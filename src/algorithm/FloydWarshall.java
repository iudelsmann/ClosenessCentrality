package algorithm;

import java.util.Arrays;

import models.Graph;

/**
 * Class with single method that implements the FloydWarshall algorithm to
 * calculate the all paths shortest path.
 */
public final class FloydWarshall {

  /**
   * Private constructor so the class can't be instantiated.
   */
  private FloydWarshall() {
  }

  /**
   * Calculates all pair shortest path for the given graph.
   *
   * @param g
   *          The graph to calculate
   * @return A matrix with the calculated distances between each vertex
   */
  public static double[][] calculate(Graph g) {
    final double[][] distances;
    // Initially the result is the adjacency matrix
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
