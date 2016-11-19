package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

  private Graph graph;

  @Before
  public void setUp() {
    graph = new Graph(5, false);
  }

  @Test
  public void constructorTest() {
    assertEquals(5, graph.getSize());
    assertEquals(false, graph.isDirected());
  }

  @Test
  public void addEdgeTest_NotDirected() {
    Double weight = Double.valueOf(10.0);
    graph.addEdge(2, 4, weight);
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[2][4]).compareTo(weight) == 0);
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[4][2]).compareTo(weight) == 0);
  }

  @Test
  public void addEdgeTest_Directed() {
    graph = new Graph(5, true);
    Double weight = Double.valueOf(10.0);
    graph.addEdge(2, 4, weight);
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[2][4]).compareTo(weight) == 0);
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[4][2]).compareTo(weight) != 0);
  }

}
