package ucu.edu.ua.apps;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * Represents a bucket that contains multiple flower packs. A bucket can hold various types and
 * quantities of flowers.
 */
public final class FlowerBucket {
  @Getter private List<FlowerPack> flowerPacks;

  /**
   * Adds a flower pack to this bucket.
   *
   * @param flowerPack the flower pack to add
   */
  public void addFlowerPack(final FlowerPack flowerPack) {
    if (flowerPacks == null) {
      flowerPacks = new ArrayList<>();
    }
    flowerPacks.add(flowerPack);
  }

  /**
   * Calculates the total price of all flower packs in this bucket.
   *
   * @return the total price
   */
  public double getPrice() {
    double price = 0;
    for (FlowerPack flowerPack : flowerPacks) {
      price += flowerPack.getPrice();
    }
    return price;
  }
}
