package algorithm;

import models.Graph;

/**
 * Class that implements an algorithm to calculate the closeness centrality of
 * all vertex of a given graph
 */
public final class ClosenessCentrality {

  /**
   * Private constructor so the class can't be instantiated.
   */
  private ClosenessCentrality() {
  }

  /**
   * Calculates the closeness centrality of the given graph.
   *
   * @param g
   *          The graph to calculate
   * @return An array with the closeness of all vertexes
   */
  public static Double[] calculate(Graph g) {
    double[][] distances = FloydWarshall.calculate(g);
    Double[] result = new Double[distances.length];
    for (int i = 0; i < distances.length; i++) {
      double sum = 0;
      for (int j = 0; j < distances.length; j++) {
        sum += distances[i][j];
      }
      result[i] = (g.getSize() - 1) / sum;
    }
    return result;
  }
}
