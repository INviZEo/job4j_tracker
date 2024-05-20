package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected final List<Food> foods = new ArrayList<>();
    protected static final double ZERO = 0;
    protected static final double TWENTYFIVE = 25;
    protected static final double SEVENTYFIVE = 75;
    protected static final double ONEHUNDRED = 100;

    @Override
    public List<Food> getAllFood() {
        return foods;
    }

    @Override
    public abstract boolean add(Food food, double limit);
}
