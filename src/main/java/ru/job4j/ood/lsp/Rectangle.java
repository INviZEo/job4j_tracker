package ru.job4j.ood.lsp;

public class Rectangle {
    int a = 10;
    int b = 5;
    int e = 555;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return "Rectangle{"
                + "a=" + a
                + ", b=" + b
                + ", e=" + e
                + '}';
    }
}
