package ucu.edu.ua.apps;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ColorFilter implements SearchFilter {
  private FlowerColor color;

  @Override
  public boolean match(Flower flower) {
    return flower.getColor() == color;
  }
}
