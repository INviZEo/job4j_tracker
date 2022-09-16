package ru.job4j.collection;

import java.util.Objects;

public class AccountBank {
    private String requisite;
    private double balance;

    public AccountBank(String requisite, double balance) {
        this.balance = balance;
        this.requisite = requisite;

    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountBank accountBank = (AccountBank) o;
        return Objects.equals(requisite, accountBank.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
