package ucu.edu.ua.apps;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PriceFilter implements SearchFilter {
    private double minPrice;
    private double maxPrice;

    @Override
    public boolean match(Flower flower) {
        return flower.getPrice() >= minPrice && flower.getPrice() <= maxPrice;
    }
}