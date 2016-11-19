package models;

/**
 * Class to create string - double pairs ordered by the double value.
 */
public class NamePair implements Comparable<NamePair> {

  /**
   * The index.
   */
  private final String name;

  /**
   * The value.
   */
  private final double value;

  /**
   * Constructor that receives both values as arguments.
   *
   * @param index
   *          The index
   * @param value
   *          The value for the given index
   */
  public NamePair(String name, double value) {
    this.name = name;
    this.value = value;
  }

  @Override
  public int compareTo(NamePair other) {
    return Double.valueOf(this.value).compareTo(other.getValue());
  }

  public String getName() {
    return name;
  }

  public double getValue() {
    return value;
  }

}
