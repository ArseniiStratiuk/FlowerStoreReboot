package ucu.edu.ua.apps;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a flower store that contains flower buckets. Provides functionality to search for
 * flowers based on criteria.
 */
public final class Store {
  /** The list of flower buckets in this store. */
  private final List<FlowerBucket> flowerBuckets = new ArrayList<>();

  /**
   * Adds a flower bucket to the store.
   *
   * @param flowerBucket the bucket to add
   */
  public void add(final FlowerBucket flowerBucket) {
    flowerBuckets.add(flowerBucket);
  }

  /**
   * Searches for flowers matching the given filter criteria.
   *
   * @param filter the search filter to apply
   * @return list of matching flowers
   */
  public List<Flower> search(final SearchFilter filter) {
    List<Flower> foundFlowers = new ArrayList<>();
    for (FlowerBucket bucket : flowerBuckets) {
      for (FlowerPack pack : bucket.getFlowerPacks()) {
        if (filter.match(pack.getFlower())) {
          foundFlowers.add(pack.getFlower());
        }
      }
    }
    return foundFlowers;
  }
}
