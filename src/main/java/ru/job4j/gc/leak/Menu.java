package ru.job4j.gc.leak;

import java.util.Random;
import java.util.Scanner;

public class Menu {

    public static final int ADD_POST = 1;
    public static final int ADD_MANY_POST = 2;
    public static final int SHOW_ALL_POSTS = 3;
    public static final int DELETE_POST = 4;

    public static final String SELECT = "Выберите меню";
    public static final String COUNT = "Выберите количество создаваемых постов";
    public static final String TEXT_OF_POST = "Введите текст";
    public static final String EXIT = "Конец работы";

    public static final String MENU = """
                Введите 1 для создание поста.
                Введите 2, чтобы создать определенное количество постов.
                Введите 3, чтобы показать все посты.
                Введите 4, чтобы удалить все посты.
                Введите любое другое число для выхода.
            """;

    public static void main(String[] args) {
        Random random = new Random();
        UserGenerator userGenerator = new UserGenerator(random);
        CommentGenerator commentGenerator = new CommentGenerator(random, userGenerator);
        Scanner scanner = new Scanner(System.in);
        PostStore postStore = new PostStore();
        start(commentGenerator, scanner, userGenerator, postStore);
    }

    private static void start(CommentGenerator commentGenerator, Scanner scanner, UserGenerator userGenerator, PostStore postStore) {
        boolean run = true;
        while (run) {
            try {
                System.out.println(MENU);
                System.out.println(SELECT);
                int userChoice = Integer.parseInt(scanner.nextLine());
                System.out.println(userChoice);
                switch (userChoice) {
                    case ADD_POST:
                        System.out.println(TEXT_OF_POST);
                        String postSolo = scanner.nextLine();
                        userGenerator.generate();
                        commentGenerator.generate();
                        postStore.add(new Post(postSolo, CommentGenerator.getComments()));
                        break;
                    case ADD_MANY_POST:
                        System.out.println(TEXT_OF_POST);
                        String postMultiple = scanner.nextLine();
                        System.out.println(COUNT);
                        String count = scanner.nextLine();
                        for (int i = 0; i < Integer.parseInt(count); i++) {
                            createPost(commentGenerator, userGenerator, postStore, postMultiple);
                        }
                    case SHOW_ALL_POSTS:
                        System.out.println(PostStore.getPosts());
                        break;
                    case DELETE_POST:
                        postStore.removeAll();
                        System.out.println("Все посты были удалены.");
                        break;
                    default:
                        run = false;
                        System.out.println(EXIT);
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите действительное число.");
            }
        }
    }

    private static void createPost(CommentGenerator commentGenerator,
                                   UserGenerator userGenerator, PostStore postStore, String text) {
        userGenerator.generate();
        commentGenerator.generate();
        postStore.add(new Post(text, CommentGenerator.getComments()));
    }
}