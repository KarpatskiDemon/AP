import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = perevirka();

        while (true) {
            System.out.println("Виберіть, яку функцію викликати:");
            System.out.println("1. Функція, яка приймає строку. Ця функція має повертати перевернуту строку - останній символ строки має бути першим, передостанній - другим, і так далі.");
            System.out.println("2. Функція, яка приймає строку. Ця функція має повертати строку, в якій кожне слово - перевернуте. Сам порядодк слів не має змінюватись.");

            if (s.hasNextInt()) {
                int diya = s.nextInt();
                s.nextLine();

                if (diya == 1) {
                    System.out.println("Функція, яка приймає строку. Ця функція має повертати перевернуту строку - останній символ строки має бути першим, передостанній - другим, і так далі: " + revstr(str));
                    break;
                } else if (diya == 2) {
                    System.out.println("функція, яка приймає строку. Ця функція має повертати строку, в якій кожне слово - перевернуте. Сам порядодк слів не має змінюватись: " + revwords(str));
                    break;
                } else {
                    System.out.println("Невірний вибір! Спробуйте ще раз.");
                }
            } else {
                System.out.println("Будь ласка, введіть ціле число (1/2).");
                s.nextLine();
            }
        }
    }

    public static String perevirka() {
        Scanner s = new Scanner(System.in);
        String str;
        while (true) {
            System.out.println("Введіть мінімум 2 слова, кожне з яких містить не менше 3 літер:");
            str = s.nextLine();
            String[] words = str.split(" ");

            if (words.length >= 2) {
                boolean corword = true;
                for (String word : words) {
                    if (word.length() < 3) {
                        corword = false;
                        break;
                    }
                }
                if (corword) return str;
            }
            System.out.println("Невірно! Переконайтеся, що ввели щонайменше 2 слова, і кожне містить не менше 3 літер.");
        }
    }

    public static String revstr(String str) {
        String res = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }
        return res;
    }

    public static String revwords(String str) {
        String[] words = str.split(" ");
        String res = "";

        for (String word : words) {
            String revword = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                revword += word.charAt(i);
            }
            res += revword + " ";
        }

        return res.trim();
    }
}