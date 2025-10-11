package ucu.edu.ua.apps;

import lombok.AllArgsConstructor;

/** Filter that matches flowers within a price range. */
@AllArgsConstructor
public final class PriceFilter implements SearchFilter {
  /** The minimum price (inclusive). */
  private final double minPrice;

  /** The maximum price (inclusive). */
  private final double maxPrice;

  @Override
  public boolean match(final Flower flower) {
    return flower.getPrice() >= minPrice && flower.getPrice() <= maxPrice;
  }
}
