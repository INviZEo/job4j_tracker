package ru.job4j.ood.lsp;

import java.util.List;

public class ControlQuality {
    Store store;
    Trash trash;

    public List<Food> foodTest(Food food) {
        Food rsl = null;
        if (food.createDate > 100) {
            trash.getFood(food);
        }
        return null;
    }
}
