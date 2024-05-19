package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

@Disabled
class ControlQualityTest {

    @Test
    public void testBadQuality() {
        List<Store> store = new ArrayList<>();
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        store.add(shop);
        store.add(trash);
        store.add(warehouse);
        Food food1 = new Food("Govenoye apple",
                new GregorianCalendar(2024, Calendar.DECEMBER, 14),
                new GregorianCalendar(2024, Calendar.MAY, 14), 100, 0);
        ControlQuality controlQuality = new ControlQuality(store);
        controlQuality.distribute(food1, new GregorianCalendar(2024, Calendar.MAY, 14));
        Assertions.assertEquals(food1.getName(), trash.getAllFood().get(0).getName());
    }

    @Test
    public void testQuality() {
        List<Store> store = new ArrayList<>();
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        store.add(shop);
        store.add(trash);
        store.add(warehouse);
        Food food = new Food("Apple",
                new GregorianCalendar(2024, Calendar.DECEMBER, 14),
                new GregorianCalendar(2024, Calendar.JULY, 14), 100, 0);
        ControlQuality controlQuality = new ControlQuality(store);
        controlQuality.distribute(food, new GregorianCalendar(2024, Calendar.MAY, 14));
        Assertions.assertEquals(food.getName(), shop.getAllFood().get(0).getName());
    }

    @Test
    public void testDiscount() {
        List<Store> store = new ArrayList<>();
        Shop shop = new Shop();
        store.add(shop);
        Food food = new Food("Apple",
                new GregorianCalendar(2024, Calendar.JANUARY, 14),
                new GregorianCalendar(2024, Calendar.JUNE, 30), 100, 0);
        ControlQuality controlQuality = new ControlQuality(store);
        controlQuality.distribute(food, new GregorianCalendar(2024, Calendar.FEBRUARY, 10));
        Assertions.assertEquals(80, food.getPrice());
    }
}