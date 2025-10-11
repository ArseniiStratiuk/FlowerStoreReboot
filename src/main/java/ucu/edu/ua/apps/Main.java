package ucu.edu.ua.apps;

public class Main {
  public static void main(String[] args) {
    // CHECKSTYLE:OFF
    FlowerColor flowerColor = FlowerColor.RED;
    System.out.println(flowerColor); // "#FF0000"
    Flower flower = new Flower(100, FlowerColor.RED, 100, FlowerType.ROSE);
    FlowerPack flowerPack1 = new FlowerPack(flower, 10);
    FlowerPack flowerPack2 = new FlowerPack(flower, 20);
    System.out.println(flowerPack1.getPrice());
    System.out.println(flowerPack2.getPrice());
    flower.setPrice(80);
    System.out.println(flowerPack1.getPrice());
    System.out.println(flowerPack2.getPrice());
    // CHECKSTYLE:ON
  }
}
