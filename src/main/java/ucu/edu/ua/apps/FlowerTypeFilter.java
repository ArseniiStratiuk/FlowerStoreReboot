package ucu.edu.ua.apps;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FlowerTypeFilter implements SearchFilter {
  private FlowerType flowerType;

  @Override
  public boolean match(Flower flower) {
    return flower.getFlowerType() == flowerType;
  }
}
