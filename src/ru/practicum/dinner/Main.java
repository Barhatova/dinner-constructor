package ru.practicum.dinner;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Такой команды нет");
                    System.out.println();
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать: ");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        if (numberOfCombos <= 0) {
            System.out.println("Ввведено некорректное значение. Значение должно быть положительным");
            return;
        }

        ArrayList<String> categoryList = new ArrayList<>();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                "Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        while (!nextItem.isEmpty()) {
            String type = nextItem;
            if (dc.checkType(type)) {
                categoryList.add(nextItem);
                nextItem = scanner.nextLine();
            } else {
                System.out.println("Введен несуществующий тип блюд. Введите другой тип");
                break;
            }
        }

        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(dc.generateCombos(categoryList));
            System.out.println();
        }
    }
}

