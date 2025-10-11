package ucu.edu.ua.apps;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<FlowerBucket> flowerBuckets = new ArrayList<>();

    public void add(FlowerBucket flowerBucket) {
        flowerBuckets.add(flowerBucket);
    }

    public List<Flower> search(SearchFilter filter) {
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