package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore {
    List<Food> trash = new ArrayList<>();

    @Override
    public List<Food> getFood(Food food) {
        if (food.getCreateDate() > 100) {
            trash.add(food);
        }
        return trash;
    }
}
