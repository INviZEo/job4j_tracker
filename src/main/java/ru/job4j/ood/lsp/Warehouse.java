package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Warehouse extends AbstractStore {
    List<Food> warehouseFood = new ArrayList<>();

    @Override
    public List<Food> getFood(Food food, Calendar calendar) {
        if ((calendar.getTime().getTime() - food.getExpiredDate().getTime().getTime() * 100)
                / (food.getExpiredDate().getTime().getTime() - food.getCreateDate().getTime().getTime()) > 25) {
            warehouseFood.add(food);
        }
        return warehouseFood;
    }
}
