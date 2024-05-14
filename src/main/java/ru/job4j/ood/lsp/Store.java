package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public interface Store {
    List<Food> getFood(Food food, Calendar calendar);
}
