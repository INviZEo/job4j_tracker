package ru.job4j.ood.isp;

public class Lines implements Line {
    @Override
    public int pointA() {
        return 0;
    }

    @Override
    public int pointB() {
        return 0;
    }

    @Override
    public double perimeter() { /*У Линии всего одна сторона от точки а к точке б или наоборот в общем периметр не нужен*/
        return 0;
    }
}
