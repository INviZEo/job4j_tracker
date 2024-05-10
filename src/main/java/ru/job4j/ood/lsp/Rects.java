package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Rects {
    /* происходит нарушение когда квадрат у которого стороны
     равны получает данные сторон от прямоугольника и тем самым уже перестаёт быть квадратом */
    public static void main(String[] args) {
        List<Rectangle> rects = new ArrayList<>();
        rects.add(new Rectangle());
        rects.add(new Square());
        rects.add(new Square());
        rects.get(0).setA(1111);
        rects.get(1).setA(54);
        rects.get(1).setB(78);
        System.out.println(rects);
    }
}
