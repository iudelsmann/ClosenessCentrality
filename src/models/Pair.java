package models;

/**
 * Simple comparable pair class with int index and double value.
 */
public class Pair implements Comparable<Pair> {

  /**
   * The index
   */
  private final int index;

  /**
   * The value
   */
  private final double value;

  /**
   * Constructor that receives both values as arguments
   *
   * @param index
   *          The index
   * @param value
   *          The value for the given index
   */
  public Pair(int index, double value) {
    this.index = index;
    this.value = value;
  }

  public int compareTo(Pair other) {
    return Double.valueOf(this.value).compareTo(other.value);
  }

  public int getIndex() {
    return index;
  }

  public double getValue() {
    return value;
  }
}