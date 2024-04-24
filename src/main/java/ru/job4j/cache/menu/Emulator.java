package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Emulator {

    final static int FINDPATH = 1;
    final static int LOADFILE = 2;
    final static int GETFILE = 3;
    final static int EXIT = 4;

    private static DirFileCache dirFileCache;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Выберите пункт");
            System.out.println("1 = указать кэшируемую директорию");
            System.out.println("2 = загрузить содержимое файла в кэш");
            System.out.println("3 = получить содержимое файла из кэша");
            System.out.println("4 = ВЫХОД");
            System.out.print("Ваш выбор: ");
            int menu = Integer.parseInt(scanner.nextLine());
            if (menu == FINDPATH) {
                System.out.print("Введите путь: ");
                String pathName = scanner.nextLine();
                dirFileCache = new DirFileCache(pathName);
            }
            if (menu == LOADFILE) {
                if (dirFileCache != null) {
                    System.out.print("Введите имя файла: ");
                    String fileName = scanner.nextLine();
                    dirFileCache.put(fileName, dirFileCache.get(fileName));
                } else {
                    System.out.println("Укажите корректную директорию");
                }
            }
            if (menu == GETFILE) {
                if (dirFileCache != null) {
                    System.out.print("Введите имя файла: ");
                    String fileName = scanner.nextLine();
                    System.out.println(dirFileCache.get(fileName));
                } else {
                    System.out.println("Укажите корректную директорию");
                }
            }
            if (menu == EXIT) {
                System.out.println("Выход из программы");
                run = false;
            }
        }
    }
}
