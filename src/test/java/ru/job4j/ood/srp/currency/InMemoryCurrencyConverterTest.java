package ru.job4j.ood.srp.currency;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.ood.srp.currency.Currency.RUB;
import static ru.job4j.ood.srp.currency.Currency.USD;

class InMemoryCurrencyConverterTest {
    @Test
    public void ConvertSalary() {
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Denis", now, now, 2500);
        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        assertThat(converter.convert(USD, worker.getSalary(), RUB)).isEqualTo(162500);
    }
}