package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        List<Value> values = new ArrayList<>();
        List<Suit> suits = new ArrayList<>();
        Stream.of(Suit.values())
                .flatMap(value -> Stream.of(suits)
                .map(suit -> values + " " + suit))
                .forEach(System.out::println);
    }
}
