package ucu.edu.ua.apps;

/** Represents the color of a flower. Each color has a hexadecimal representation. */
public enum FlowerColor {
  /** Red color. */
  RED("#FF0000"),
  /** Green color. */
  GREEN("#008000"),
  /** Blue color. */
  BLUE("#0000FF"),
  /** White color. */
  WHITE("#FFFFFF"),
  /** Yellow color. */
  YELLOW("#FFFF00");

  /** The hexadecimal representation of the color. */
  private final String hexColor;

  FlowerColor(final String newHexColor) {
    this.hexColor = newHexColor;
  }

  @Override
  public String toString() {
    return hexColor;
  }
}
