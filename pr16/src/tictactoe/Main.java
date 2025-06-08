package tictactoe;

import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import tictactoe.game.Game;
import tictactoe.savestncfg.*;
import tictactoe.Const;

public class Main {

    public static void main(String[] args) {
        Stats.loadStats();
        while (true) {
            int choice = mainMenu();
            if (choice == 1) {
                Game.game(Const.size);
            } else if (choice == 2) {
                int newSize = settings(Const.size);
                if (newSize != -1) {
                    Const.size = newSize;
                    System.out.println("Розмір поля змінено!");
                    Config.saveConfig(Const.size, Const.p1Name, Const.p2Name);
                }
            } else if (choice == 3) {
                Stats.printStats();
            } else if (choice == 4) {
                Config.printConfig(Const.size, Const.p1Name, Const.p2Name);
            } else if (choice == 5) {
                Stats.saveStats();
                Config.saveConfig(Const.size, Const.p1Name, Const.p2Name);
                System.out.println("Ви обрали вихід!");
                return;
            } else {
                System.out.println("Щось не те, спробуйте ще раз!");
            }
        }
    }

     

    public static void mainMenu() {
        String menu = """
                \n1. Грати(Нова гра)
                2. Налаштування
                3. Переглянути статистику
                4. Переглянути конфіг
                5. Вихід
                """;
        System.out.println(menu);
        System.out.print("Сюди : ");
        if (Const.sc.hasNextInt()) {
            int choice = Const.sc.nextInt();
            Const.sc.nextLine();
            return choice;
        }
        Const.sc.nextLine();
        return -1;
    }

    public static void mainMenuChoice(){

    }

    public static int settings(int currentSize) {
        System.out.println("\nВи обрали налаштування!");
        while (true) {
            System.out.println("""
                    \nОберіть розмір поля :
                    1. 3x3
                    2. 5x5
                    3. 7x7
                    4. 9x9
                    5. Змінити ім'я гравця
                    6. Головне меню""");
            System.out.print("\nСюди : ");
            if (Const.sc.hasNextInt()) {
                int choice = Const.sc.nextInt();
                Const.sc.nextLine();
                int size = -1;
                if (choice == 1) {
                    size = 5;
                    currentSize = size;
                } else if (choice == 2) {
                    size = 9;
                    currentSize = size;
                } else if (choice == 3) {
                    size = 13;
                    currentSize = size;
                } else if (choice == 4) {
                    size = 17;
                    currentSize = size;
                } else if (choice == 5) {
                    System.out.print("Введіть ім'я першого гравця(X) : ");
                    Const.p1Name = Const.sc.nextLine();
                    System.out.print("Введіть ім'я другого гравця(O) : ");
                    Const.p2Name = Const.sc.nextLine();
                    System.out.println("Імена гравців змінено!");
                    Config.saveConfig(currentSize, Const.p1Name, Const.p2Name);
                    return -1;
                } else if (choice == 6) {
                    return -1;
                } else {
                    System.out.println("Немає такого (( (правильно буде число від 1 до 6)");
                }
                if(size != -1){
                    return size;
                }
            } else {
                System.out.println("Ви ввели не число! Спробуйте ще раз.");
                Const.sc.nextLine();
            }
        }
    }
}
