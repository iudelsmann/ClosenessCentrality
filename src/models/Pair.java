package models;

public class Pair implements Comparable<Pair> {
  private final int index;
  private final double value;

  public Pair(int index, double value) {
    this.index = index;
    this.value = value;
  }

  @Override
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