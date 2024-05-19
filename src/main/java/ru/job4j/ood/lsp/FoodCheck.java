package ru.job4j.ood.lsp;

import java.util.Calendar;

public class FoodCheck {

    public double check(Food food, Calendar calendar) {
        return (double) ((Math.abs(calendar.getTime().getTime() - food.getExpiredDate().getTime().getTime()) * 100)
                / Math.abs(food.getExpiredDate().getTime().getTime() - food.getCreateDate().getTime().getTime()));
    }
}
