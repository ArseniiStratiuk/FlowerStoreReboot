package ucu.edu.ua.apps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test class for Store. */
public final class StoreTest {
  /** Price of a rose for testing. */
  private static final int ROSE_PRICE = 10;
  /** Price of a chamomile for testing. */
  private static final int CHAMOMILE_PRICE = 5;
  /** Price of a tulip for testing. */
  private static final int TULIP_PRICE = 8;
  /** Quantity of flowers in a pack for testing. */
  private static final int PACK_QUANTITY = 10;
  /** Minimum price for filter testing. */
  private static final int MIN_PRICE_FILTER = 7;
  /** Maximum price for filter testing. */
  private static final int MAX_PRICE_FILTER = 11;

  /** The store instance being tested. */
  private Store store;

  /** Initializes the test environment before each test. */
  @BeforeEach
  public void init() {
    store = new Store();
    Flower rose = new Rose();
    rose.setPrice(ROSE_PRICE);
    rose.setColor(FlowerColor.RED);
    Flower chamomile = new Chamomile();
    chamomile.setPrice(CHAMOMILE_PRICE);
    chamomile.setColor(FlowerColor.WHITE);
    Flower tulip = new Tulip();
    tulip.setPrice(TULIP_PRICE);
    tulip.setColor(FlowerColor.RED);

    FlowerPack rosePack = new FlowerPack(rose, PACK_QUANTITY);
    FlowerPack chamomilePack = new FlowerPack(chamomile, PACK_QUANTITY);
    FlowerPack tulipPack = new FlowerPack(tulip, PACK_QUANTITY);

    FlowerBucket bucket = new FlowerBucket();
    bucket.addFlowerPack(rosePack);
    bucket.addFlowerPack(chamomilePack);
    bucket.addFlowerPack(tulipPack);

    store.add(bucket);
  }

  /** Tests searching flowers by color. */
  @Test
  public void testSearchByColor() {
    SearchFilter filter = new ColorFilter(FlowerColor.RED);
    List<Flower> found = store.search(filter);
    assertEquals(2, found.size());
    for (Flower flower : found) {
      assertEquals(FlowerColor.RED, flower.getColor());
    }
  }

  /** Tests searching flowers by price range. */
  @Test
  public void testSearchByPrice() {
    SearchFilter filter = new PriceFilter(MIN_PRICE_FILTER, MAX_PRICE_FILTER);
    List<Flower> found = store.search(filter);
    assertEquals(2, found.size());
    for (Flower flower : found) {
      assert flower.getPrice() >= MIN_PRICE_FILTER
          && flower.getPrice() <= MAX_PRICE_FILTER;
    }
  }

  /** Tests searching flowers by flower type. */
  @Test
  public void testSearchByFlowerType() {
    SearchFilter filter = new FlowerTypeFilter(FlowerType.ROSE);
    List<Flower> found = store.search(filter);
    assertEquals(1, found.size());
    for (Flower flower : found) {
      assertEquals(FlowerType.ROSE, flower.getFlowerType());
    }
  }
}
