package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Warehouse extends AbstractStore {

    @Override
    public boolean add(Food food, double limit) {
        boolean rsl = false;
        if (limit < TWENTYFIVE && limit > 0) {
            foods.add(food);
            rsl = true;
        }
        return rsl;
    }
}
