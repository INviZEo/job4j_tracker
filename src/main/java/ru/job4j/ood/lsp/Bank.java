package ru.job4j.ood.lsp;

public class Bank {
    public int duty;

    public Bank(int duty) {
        this.duty = duty;
    }

    public void credit(int time) {
        if (duty == 0) {
            throw new IllegalArgumentException("Credit paid");
        }
        if (time < 7) {
            duty += 100;
            time = 0;
        }
    }

    class BankDuty extends Bank {

        public BankDuty(int duty) {
            super(duty);
        }

        public void credit(int time) {
            if (duty == 0 && time < 3) {
                throw new IllegalArgumentException("Credit paid");
                /* Здесь нарушение в том что усиливается условие класса родителя*/
            }
            if (time < 7) {
                duty += 100;
                time = 0;
            }
        }
    }
}
