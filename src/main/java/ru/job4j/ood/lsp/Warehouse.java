package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {
    List<Food> warehouseFood = new ArrayList<>();

    @Override
    public List<Food> getFood(Food food) {
        if (food.getCreateDate() < 25) {
            warehouseFood.add(food);
        }
        return warehouseFood;
    }
}
