package ru.job4j.ood.lsp;

public class Square extends Rectangle {

    int a = 25;

    @Override
    public int getA() {
        return a;
    }

    @Override
    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Square{"
                + "a=" + a
                + ", b=" + b
                + ", e=" + e
                + '}';
    }
}
