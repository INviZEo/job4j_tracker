package ru.job4j.template;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class GeneratorTest {
    private Generator gen = new Gen();

    @Test
    public void testNameCorrect() {
        String template = "Hello, ${name}!";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Alice");
        String result = gen.produce(template, args);
        Assertions.assertEquals("Hello, Alice!", result);
    }

    @Test
    public void testNameNotExist() {
        String template = "Hello, ${name}!";
        Map<String, String> args = new HashMap<>();
        gen.produce(template, args);
        assertThatThrownBy(() -> gen.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}