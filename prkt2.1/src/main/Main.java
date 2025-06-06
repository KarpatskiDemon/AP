package main;

import java.util.Scanner;
import java.util.InputMismatchException;
import main.utils.Utils;

public class Main {

    public static void main(String[] args) {
        Utils.rFile();
        mainmenu();
    }

    public static void mainmenu() {
        while (true) {
            System.out.println("""
            \n😎😎😎Головне меню😎😎😎
            1. Додати запис
            2. Видалити запис
            3. Переглянути записи
            4. Вихід
            """);

            try {
                int choice = Const.s.nextInt();
                Const.s.nextLine();
                if (choice == 1) {
                    MyDiary.addNotate();
                } else if (choice == 2) {
                    MyDiary.deleteNotate();
                } else if (choice == 3) {
                    MyDiary.printNotates();
                } else if (choice == 4) {
                    System.out.println("Бажаєте зберегти щоденник? (так - 1/ні - 2)");
                    int save = Const.s.nextInt();
                    if (save == 1) {
                        Utils.wFile();
                        System.out.println("До побачення!");
                        break;
                    } else if (save == 2) {
                        System.out.println("До побачення!");
                        break;
                    }

                } else {
                    System.out.println("Невірний вибір!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помивка 😡🤬: " + e.getMessage());
                Const.s.nextLine();
            }
        }
    }

}