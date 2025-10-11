package ucu.edu.ua.apps;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class FlowerBucket {
    @Getter
    private List<FlowerPack> flowerPacks;

    public void addFlowerPack(FlowerPack flowerPack) {
        if (flowerPacks == null) {
            flowerPacks = new ArrayList<>();
        }
        flowerPacks.add(flowerPack);
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack flowerPack: flowerPacks) {
            price += flowerPack.getPrice();
        }
        return price;
    }
}
