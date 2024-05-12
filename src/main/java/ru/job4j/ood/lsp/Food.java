package ru.job4j.ood.lsp;

public class Food {
    String name;
    double expiredDate, createDate, price, discount;

    public Food(String name, double expiredDate, double createDate, double price, double discount) {
        this.name = name;
        this.expiredDate = expiredDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(double expiredDate) {
        this.expiredDate = expiredDate;
    }

    public double getCreateDate() {
        return createDate;
    }

    public void setCreateDate(double createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='"
                + name
                + '\''
                + ", expiredDate="
                + expiredDate
                + ", createDate="
                + createDate
                + ", price="
                + price
                + ", discount="
                + discount
                + '}';
    }
}
