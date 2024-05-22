package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ControlQuality {

    private List<Store> store;

    public ControlQuality(List<Store> store) {
        this.store = store;
    }

    public void distribute(Food food, Calendar calendar) {
        FoodCheck foodCheck = new FoodCheck();
        for (Store stores : store) {
            double check = foodCheck.check(food, calendar);
            stores.add(food, check);
        }
    }

    public void resort(List<Store> stores, Food food, Calendar calendar) {
        stores.addAll(store);
        FoodCheck foodCheck = new FoodCheck();
        for (Store stor : stores) {
            double check = foodCheck.check(food, calendar);
            stor.add(food, check);
        }
    }
}
