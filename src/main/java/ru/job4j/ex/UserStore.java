package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        if (users == null || login == null) {
            throw new UserNotFoundException("User is not found");
        }
            return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user == null) {
            throw new UserInvalidException("User is not validate or name short than 3 letters");
        }
            return false;
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = findUser(users, "Petr Arsentev");
        if (validate(user)) {
            System.out.println("This user has an access");
        }
    }
}
