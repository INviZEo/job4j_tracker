package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {
    List<Food> shopFood = new ArrayList<>();
    Store store;

    @Override
    public List<Food> getFood(Food food) {
        if (food.getCreateDate() <= 25) {
            shopFood.add(food);
        }
        if (food.getCreateDate() <= 75) {
            food.setDiscount(food.getPrice() * 0.25);
            shopFood.add(food);
        }
        return shopFood;
    }
}
