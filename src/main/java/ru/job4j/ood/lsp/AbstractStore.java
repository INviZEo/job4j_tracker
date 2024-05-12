package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore {

    public List<Food> getFood(Food food) {
        return new ArrayList<>();
    }
}
