import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "text.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    \nОберіть опцію :
                    1. Записати до файлу
                    2. Прочитати вміст файлу
                    3. Вийти
                    """);
            System.out.println("Тут :");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                if (choice == 1) {
                    wrFile();
                } else if (choice == 2) {
                    rFile();
                } else if (choice == 3) {
                    System.out.println("До побачення!");
                    break;
                } else {
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                }
            } else {
                System.out.println("Будь ласка, введіть число!");
                sc.next();
            }
        }
        sc.close();
    }

    private static void wrFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть текст (натисніть Enter для завершення):");
        String text = sc.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(text);
            System.out.println("\nТекст успішно записано до файлу.");
        } catch (IOException e) {
            System.out.println("Помилка при записі до файлу: " + e.getMessage());
        }
    }

    private static void rFile() {
        try (FileReader fr = new FileReader(FILE_NAME)) {
            System.out.println("\nВміст файлу:");
            int character;
            while ((character = fr.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не існує.");
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }
}