package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemAscByNameTest {

    @Test
    public void compare() {
         Item item0 = new Item(0, "Misha");
         Item item1 = new Item(1, "Dan");
         Item item2 = new Item(2, "Gretta");
         List<Item> items = Arrays.asList(item0, item1, item2);
         Collections.sort(items, new ItemAscByName());
         List<Item> expected = Arrays.asList(item1, item2, item0);
        Assert.assertEquals(items, expected);
    }
}