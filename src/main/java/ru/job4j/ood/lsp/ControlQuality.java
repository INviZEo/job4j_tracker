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

    public void foodTest(Food food, Calendar calendar) {
        for (Store stores : store) {
            stores.getFood(food, calendar);
        }
    }
}
