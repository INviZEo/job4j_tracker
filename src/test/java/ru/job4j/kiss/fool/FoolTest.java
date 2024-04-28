package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

class FoolTest {

    @Test
    public void checkFizzBuzz() {
        Fool.Answer fool = new Fool.Answer(15);
        Assertions.assertEquals("FizzBuzz", fool.checkAnswer());
    }

    @Test
    public void checkFizzBuzzFalse() {
        Fool.Answer fool = new Fool.Answer(6);
        Assertions.assertNotEquals("Buzz", fool.checkAnswer());
    }

    @Test
    public void checkFizz() {
        Fool.Answer fool = new Fool.Answer(3);
        Assertions.assertEquals("Fizz", fool.checkAnswer());
    }

    @Test
    public void checkFizzFalse() {
        Fool.Answer fool = new Fool.Answer(7);
        Assertions.assertNotEquals("Fizz", fool.checkAnswer());
    }

    @Test
    public void checkBuzz() {
        Fool.Answer fool = new Fool.Answer(5);
        Assertions.assertEquals("Buzz", fool.checkAnswer());
    }

    @Test
    public void checkBuzzFalse() {
        Fool.Answer fool = new Fool.Answer(6);
        Assertions.assertNotEquals("Buzz", fool.checkAnswer());

    }
}