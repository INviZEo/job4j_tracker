package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class AbstractStore implements Store {

    @Override
    public List<Food> getFood(Food food, Calendar calendar) {
        return new ArrayList<>();
    }
}
