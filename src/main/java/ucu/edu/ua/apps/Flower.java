package ucu.edu.ua.apps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
  private double sepalLength;
  private FlowerColor color;
  private double price;
  private FlowerType flowerType;
}
