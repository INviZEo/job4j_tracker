package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описвает работу банковского сервиса который может : добавлять\удалять пользователей,
 * добавлять аккаунты, искать пользователя по пасспорту или реквизитам,
 * перечислять деньги с одного пользователя другому.
 * @author invizeo
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение "пользователей" и "банковских аккаунтов" осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<AccountBank>> users = new HashMap<>();

    /**
     * метод добавляет пользователя в коллекцию если пользователь отсутствует в списке
     * @param user - пользователь добавляющийся в список
     */
    public void addUser(User user) {
      users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод ищет пользователя в коллекции по паспорту и удаляет пользователя если он не равен null
     * @param passport - пасспорт пользователя
     * @return - удаляет пользователя если он есть
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * метод производит проверку по паспорту и если аккаунта пользователя нет, метод создаёт новый аккаунт
     * @param passport - пасспорт пользователя
     * @param accountBank - аккаунт пользователя в банке
     */
    public void addAccount(String passport, AccountBank accountBank) {
        User user = findByPassport(passport);
        if (user != null) {
            List<AccountBank> accountBanks = users.get(user);
            if (!accountBanks.contains(accountBank)) {
                accountBanks.add(accountBank);
            }
        }
    }

    /**
     * метод производит поиск по пасспорту пользователей
     * @param passport - пасспорт пользователя
     * @return - возвращает аккаунт пользователя или null
     */
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

    /**
     * метод производит поиск по пасспорту и реквизитам
     * @param passport - пасспорт пользователя
     * @param requisite - реквизиты пользователя
     * @return - возвраещает аккаунт пользователя или null
     */
    public AccountBank findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        AccountBank result = null;
        if (user != null) {
            List<AccountBank> accountBanks = users.get(user);
            for (AccountBank accountBank1 : accountBanks) {
                if (accountBank1.getRequisite().equals(requisite)) {
                    result = accountBank1;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * метод позволяет перевести деньги между пользователями
     * @param srcPassport - паспорт того кто отправляет деньги
     * @param scrRequisite - реквизиты того кто отправляет деньги
     * @param destPassport - паспорт того кто получает деньги
     * @param destRequisite - реквизиты того кто получает деньги
     * @param amount - сумма отправленных денег
     * @return - проверяет количество средств на счету и позволяет провести операцию,
     * если их количество больше или равно балансу на счету отправляющего
     */
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

    /**
     * метод позволяет найти аккаунт пользователя
     * @param user - пользователь
     * @return - возвращает пользователя из списка
     */
    public List<AccountBank> getAccounts(User user) {
        return users.get(user);
    }
}

