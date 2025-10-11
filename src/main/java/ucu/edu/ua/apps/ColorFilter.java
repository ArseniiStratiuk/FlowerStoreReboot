package ucu.edu.ua.apps;

import lombok.AllArgsConstructor;

/** Filter that matches flowers by color. */
@AllArgsConstructor
public final class ColorFilter implements SearchFilter {
  /** The color to filter by. */
  private final FlowerColor color;

  @Override
  public boolean match(final Flower flower) {
    return flower.getColor() == color;
  }
}
