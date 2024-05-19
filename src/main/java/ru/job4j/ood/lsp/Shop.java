package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Shop extends AbstractStore {

    @Override
    public boolean add(Food food, double limit) {
        boolean rsl = false;
        if (limit >= TWENTYFIVE && limit <= SEVENTYFIVE) {
            FOODS.add(food);
            rsl = true;
        }
        if (limit > SEVENTYFIVE && limit < ONEHUNDRED) {
            food.setDiscount(0.2);
            food.setPrice(food.getPrice() - food.getPrice() * food.getDiscount());
            FOODS.add(food);
            rsl = true;
        }
        return rsl;
    }
}
