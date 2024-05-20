package ru.job4j.ood.lsp;

import java.util.Calendar;

public class FoodCheck {

    public double check(Food food, Calendar calendar) {
        return 100.0d - ((food.getExpiredDate().getTime().getTime() - calendar.getTime().getTime()) * 100.0d)
                / (food.getExpiredDate().getTime().getTime() - food.getCreateDate().getTime().getTime());
    }
}
