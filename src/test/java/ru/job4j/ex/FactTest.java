package ru.job4j.ex;

import static org.junit.Assert.assertThat;
import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenTestBreak() {
        Fact fact = new Fact();
        fact.calc(-1);

    }
}