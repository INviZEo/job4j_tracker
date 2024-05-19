package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class AbstractStore implements Store {

    public static final List<Food> FOODS = new ArrayList<>();
    public static final double ZERO = 0;
    public static final double TWENTYFIVE = 25;
    public static final double SEVENTYFIVE = 75;
    public static final double ONEHUNDRED = 100;

    @Override
    public List<Food> getAllFood() {
        return FOODS;
    }

    @Override
    public boolean add(Food food, double limit) {
        boolean rsl = false;
        FOODS.add(food);
        return rsl;
    }
}
