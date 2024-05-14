package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Shop extends AbstractStore {
    List<Food> shopFood = new ArrayList<>();

    @Override
    public List<Food> getFood(Food food, Calendar calendar) {
        if ((calendar.getTime().getTime() - food.getExpiredDate().getTime().getTime() * 100)
                / (food.getExpiredDate().getTime().getTime() - food.getCreateDate().getTime().getTime()) <= 25) {
            shopFood.add(food);
        }
        if ((calendar.getTime().getTime() - food.getExpiredDate().getTime().getTime() * 100)
                / (food.getExpiredDate().getTime().getTime() - food.getCreateDate().getTime().getTime()) < 75
                && (calendar.getTime().getTime() - food.getExpiredDate().getTime().getTime() * 100)
                / (food.getExpiredDate().getTime().getTime() - food.getCreateDate().getTime().getTime()) > 100) {
            food.setDiscount(0.2);
            food.setPrice(food.getPrice() - food.getPrice() * food.getDiscount());
            shopFood.add(food);
        }
        return shopFood;
    }
}
