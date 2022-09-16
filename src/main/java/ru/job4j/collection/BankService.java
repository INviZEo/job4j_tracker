package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<AccountBank>> users = new HashMap<>();

    public void addUser(User user) {
      users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, AccountBank accountBank) {
        User user = findByPassport(passport);
        if (user != null) {
            List<AccountBank> accountBanks = users.get(user);
            if (!accountBanks.contains(accountBank)) {
                accountBanks.add(accountBank);
            }
        }
    }

    public User findByPassport(String passport) {
        User pass = null;
        for (User users : users.keySet()) {
            if (passport.equals(users.getPassport())) {
                pass = users;
                break;
            }
        }
        return pass;
    }

    public AccountBank findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        AccountBank accountBank = null;
        if (user != null) {
            List<AccountBank> accountBanks = users.get(user);
            for (AccountBank accountBank1 : accountBanks) {
                if (accountBank1.getRequisite().equals(requisite)) {
                    accountBank = accountBank1;
                }
            }
        }
        return accountBank;
    }

    public boolean transferMoney(String srcPassport, String scrRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        AccountBank accountSrc = findByRequisite(srcPassport, scrRequisite);
        AccountBank accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc != null && accountDest != null && accountSrc.getBalance() >= amount) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<AccountBank> getAccounts(User user) {
        return users.get(user);
    }
}
