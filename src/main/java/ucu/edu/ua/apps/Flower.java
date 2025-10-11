package ucu.edu.ua.apps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a flower in the flower store.
 * Contains basic attributes like sepal length, color, price, and type.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
  /** The length of the flower's sepal in centimeters. */
  private double sepalLength;

  /** The color of the flower. */
  private FlowerColor color;

  /** The price of the flower. */
  private double price;

  /** The type of the flower (Rose, Tulip, Chamomile). */
  private FlowerType flowerType;
}
