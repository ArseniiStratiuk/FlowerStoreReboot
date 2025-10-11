package ucu.edu.ua.apps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a pack of identical flowers.
 * Contains a flower and the quantity in the pack.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlowerPack {
  /** The flower in this pack. */
  private Flower flower;

  /** The number of flowers in this pack. */
  private int amount;

  /**
   * Calculates the total price for this pack.
   *
   * @return the total price (flower price * amount)
   */
  public double getPrice() {
    return flower.getPrice() * amount;
  }
}
