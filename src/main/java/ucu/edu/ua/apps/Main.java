package ucu.edu.ua.apps;

/** Main class demonstrating the flower store functionality. */
public final class Main {

  /** Initial price for demo flower. */
  private static final int INITIAL_PRICE = 100;

  /** Initial sepal length for demo flower. */
  private static final int INITIAL_SEPAL_LENGTH = 100;

  /** First pack quantity. */
  private static final int PACK_QUANTITY_1 = 10;

  /** Second pack quantity. */
  private static final int PACK_QUANTITY_2 = 20;

  /** Updated price for demo flower. */
  private static final int UPDATED_PRICE = 80;

  private Main() {
    // Utility class should not be instantiated
  }

  /**
   * Main entry point for the application.
   *
   * @param args command line arguments
   */
  public static void main(final String[] args) {
    FlowerColor flowerColor = FlowerColor.RED;
    System.out.println(flowerColor); // "#FF0000"
    Flower flower = new Flower(INITIAL_PRICE, FlowerColor.RED,
        INITIAL_SEPAL_LENGTH, FlowerType.ROSE);
    FlowerPack flowerPack1 = new FlowerPack(flower, PACK_QUANTITY_1);
    FlowerPack flowerPack2 = new FlowerPack(flower, PACK_QUANTITY_2);
    System.out.println(flowerPack1.getPrice());
    System.out.println(flowerPack2.getPrice());
    flower.setPrice(UPDATED_PRICE);
    System.out.println(flowerPack1.getPrice());
    System.out.println(flowerPack2.getPrice());
  }
}
