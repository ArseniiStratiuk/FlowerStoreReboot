package ucu.edu.ua.apps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class FlowerPack {
    private Flower flower;
    private int amount;

    public double getPrice() {
        return flower.getPrice() * amount;
    }
}
