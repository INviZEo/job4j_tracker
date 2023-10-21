package ru.job4j.stream;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> product.getStandard() - product.getActual() >= 0)
                .filter(product -> product.getStandard() - product.getActual() <= 3)
                .map(product -> new Label(product.getName(), (product.getPrice() * 0.5f)).toString()).toList();
    }
}