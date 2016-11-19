package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FacebookGraphTest {

  private FacebookGraph graph;

  @Before
  public void setUp() {
    graph = new FacebookGraph(5);
  }

  @Test
  public void constructor() {
    assertEquals(5, graph.getSize());
    assertFalse(graph.isDirected());
  }

  @Test
  public void addFriendshipTest() {
    graph.addFriendShip("Pedro", "Arthur");
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[0][1]).compareTo(1.0) == 0);
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[1][0]).compareTo(1.0) == 0);
  }

  @Test
  public void addFriendShipTest_SamePerson() {
    // Same person name should keep the index
    graph.addFriendShip("Pedro", "Arthur");
    graph.addFriendShip("Pedro", "Fernando");
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[0][1]).compareTo(1.0) == 0);
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[1][0]).compareTo(1.0) == 0);
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[0][2]).compareTo(1.0) == 0);
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[2][0]).compareTo(1.0) == 0);
  }

  @Test
  public void addFriendShipTest_SamePerson_SecondArgument() {
    // Same person name should keep the index
    graph.addFriendShip("Pedro", "Arthur");
    graph.addFriendShip("Fernando", "Pedro");
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[0][1]).compareTo(1.0) == 0);
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[1][0]).compareTo(1.0) == 0);
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[0][2]).compareTo(1.0) == 0);
    assertTrue(Double.valueOf(graph.getAdjacencyMatrix()[2][0]).compareTo(1.0) == 0);
  }

  @Test
  public void getNameFromIndexTest() {
    graph.addFriendShip("Pedro", "Arthur");
    assertEquals("Pedro", graph.getNameFromIndex(0));
    assertEquals("Arthur", graph.getNameFromIndex(1));
  }

  @Test
  public void getNameFromIndexTest_EmptyGraph() {
    assertNull(graph.getNameFromIndex(0));
  }
}
