package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

class ControlQualityTest {

    @Test
    public void testQuality() {
        List<Store> store = new ArrayList<>();
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        store.add(shop);
        store.add(trash);
        store.add(warehouse);
        Food food = new Food("Зина",
                new GregorianCalendar(2024, Calendar.DECEMBER, 14),
                new GregorianCalendar(2024, Calendar.JULY, 14), 100, 0);
        Food food1 = new Food("Гораций",
                new GregorianCalendar(2024, Calendar.DECEMBER, 14),
                new GregorianCalendar(2024, Calendar.MAY, 14), 100, 0);
        ControlQuality controlQuality = new ControlQuality(store);
        controlQuality.foodTest(food, new GregorianCalendar(2024, Calendar.MAY, 14));
        controlQuality.foodTest(food1, new GregorianCalendar(2024, Calendar.MAY, 14));
    }
}