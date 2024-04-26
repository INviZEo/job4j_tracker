package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

class FoolTest {

    @Test
    public void checkFizzBuzz() {
        boolean result = Fool.checkAnswer(15, "FizzBuzz");
        Assertions.assertTrue(result);
    }

    @Test
    public void checkFizzBuzzFalse() {
        boolean result = Fool.checkAnswer(16, "FizzBuzz");
        Assertions.assertFalse(result);
    }

    @Test
    public void checkFizz() {
        boolean result = Fool.checkAnswer(3, "Fizz");
        Assertions.assertTrue(result);
    }

    @Test
    public void checkFizzFalse() {
        boolean result = Fool.checkAnswer(4, "Fizz");
        Assertions.assertFalse(result);
    }

    @Test
    public void checkBuzz() {
        boolean result = Fool.checkAnswer(5, "Buzz");
        Assertions.assertTrue(result);
    }

    @Test
    public void checkBuzzFalse() {
        boolean result = Fool.checkAnswer(7, "Buzz");
        Assertions.assertFalse(result);
    }
}