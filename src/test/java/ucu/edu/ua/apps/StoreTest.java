package ucu.edu.ua.apps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoreTest {
  private Store store;

  @BeforeEach
  public void init() {
    store = new Store();
    Flower rose = new Rose();
    rose.setPrice(10);
    rose.setColor(FlowerColor.RED);
    Flower chamomile = new Chamomile();
    chamomile.setPrice(5);
    chamomile.setColor(FlowerColor.WHITE);
    Flower tulip = new Tulip();
    tulip.setPrice(8);
    tulip.setColor(FlowerColor.RED);

    FlowerPack rosePack = new FlowerPack(rose, 10);
    FlowerPack chamomilePack = new FlowerPack(chamomile, 10);
    FlowerPack tulipPack = new FlowerPack(tulip, 10);

    FlowerBucket bucket = new FlowerBucket();
    bucket.addFlowerPack(rosePack);
    bucket.addFlowerPack(chamomilePack);
    bucket.addFlowerPack(tulipPack);

    store.add(bucket);
  }

  @Test
  public void testSearchByColor() {
    SearchFilter filter = new ColorFilter(FlowerColor.RED);
    List<Flower> found = store.search(filter);
    assertEquals(2, found.size());
    for (Flower flower : found) {
      assertEquals(FlowerColor.RED, flower.getColor());
    }
  }

  @Test
  public void testSearchByPrice() {
    SearchFilter filter = new PriceFilter(7, 11);
    List<Flower> found = store.search(filter);
    assertEquals(2, found.size());
    for (Flower flower : found) {
      assert flower.getPrice() >= 7 && flower.getPrice() <= 11;
    }
  }

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
