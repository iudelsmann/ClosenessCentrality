package models;

/**
 * Class to represent graphs. Uses the adjacency matrix version.
 *
 */
public class Graph {

  /**
   * Adjacency matrix for this graph
   */
  private double[][] adjacencyMatrix;

  /**
   * Indicates if this graph is directed
   */
  private boolean directed = false;

  /**
   * The number of vertexes in this graph
   */
  private int size;

  /**
   * Constructor that receives the number of vertexes of the graph and a boolean
   * indicating if it is directed
   *
   * @param size
   *          The number of vertexes in the graph
   * @param directed
   *          Indicates if the graph is oriented
   */
  public Graph(int size, boolean directed) {
    this.adjacencyMatrix = new double[size][size];
    this.directed = directed;
    this.size = size;
    this.init();
  }

  /**
   * Initializes the adjacency matrix setting all positions to positive infinity
   * except for the diagonal that has all zeros
   */
  private void init() {
    for (int i = 0; i < this.size; i++) {
      for (int j = 0; j < this.size; j++) {
        if (i == j) {
          this.adjacencyMatrix[i][i] = 0;
        } else {
          this.adjacencyMatrix[i][j] = Double.POSITIVE_INFINITY;
        }
      }
    }
  }

  /**
   * Adds an edge to the graph with the given weight
   *
   * @param from
   *          The origin of the edge
   * @param to
   *          To destination of the edge
   * @param weight
   *          The weight of the edge
   */
  public void addEdge(int from, int to, double weight) {
    this.adjacencyMatrix[from][to] = weight;
    if (!this.directed) {
      this.adjacencyMatrix[to][from] = weight;
    }
  }

  public boolean isDirected() {
    return directed;
  }

  public int getSize() {
    return size;
  }

  public double[][] getAdjacencyMatrix() {
    return adjacencyMatrix;
  }

}
