package ru.job4j.ood.lsp;

import java.util.Calendar;
import java.util.Objects;

public class Food {
    String name;
    double price, discount;
    Calendar expiredDate, createDate;

    public Food(String name, Calendar createDate, Calendar expiredDate, double price, double discount) {
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

    public Calendar getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Calendar expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(price, food.price) == 0
                && Double.compare(discount, food.discount) == 0
                && Objects.equals(name, food.name)
                && Objects.equals(expiredDate, food.expiredDate)
                && Objects.equals(createDate, food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, discount, expiredDate, createDate);
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
