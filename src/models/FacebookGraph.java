package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to represent a graph where vertexes are persons and edges are
 * friendships.
 *
 */
public class FacebookGraph extends Graph {

  /**
   * Map to save the users name and an index for that person.
   */
  private Map<String, Integer> vertexNames;

  /**
   * Counter to keep track of indexes.
   */
  private Integer indexCounter = 0;

  /**
   * Constructor, that initializes the graph.
   *
   * @param size
   *          The number of vertexes in the graph
   * @param directed
   *          Indicates if the graph is oriented
   */
  public FacebookGraph(int size) {
    super(size, false);
    this.vertexNames = new HashMap<>();
  }

  /**
   * Adds a friendship to the graph.
   *
   * @param firstPerson
   *          A persons name
   * @param secondPerson
   *          Another persons name
   *
   */
  public void addFriendShip(String firstPerson, String secondPerson) {
    Integer fromIndex = this.vertexNames.get(firstPerson);
    if (fromIndex == null) {
      fromIndex = this.indexCounter;
      this.indexCounter++;
      this.vertexNames.put(firstPerson, fromIndex);
    }
    Integer toIndex = this.vertexNames.get(secondPerson);
    if (toIndex == null) {
      toIndex = this.indexCounter;
      this.indexCounter++;
      this.vertexNames.put(secondPerson, toIndex);
    }
    super.addEdge(fromIndex, toIndex, 1.0);
  }

  /**
   * From the given index finds the name of the person.
   *
   * @param index
   *          The index of the person searched
   * @return The name of the person of that given index
   */
  public String getNameFromIndex(int index) {
    for (Map.Entry<String, Integer> entry : this.vertexNames.entrySet()) {
      if (entry.getValue().equals(index)) {
        return entry.getKey();
      }
    }
    return null;
  }

}
