package ru.job4j.pojo;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class LicenceTest {

    @Test
    public void eqName() {
        Licence first = new Licence();
        first.setCode("audio");
        Licence second = new Licence();
        second.setCode("audio");
        assertThat(first, is(second));
    }
}