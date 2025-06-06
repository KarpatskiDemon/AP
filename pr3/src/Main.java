import java.text.MessageFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведення даних:");
        //int
        System.out.print("Введіть ціле число (int): ");
        int a = Integer.parseInt(scanner.nextLine());
        //double
        System.out.print("Введіть число з плаваючею крапкою (double): ");
        double b = Double.parseDouble(scanner.nextLine());
        //string
        System.out.print("Введіть строку: ");
        String c = scanner.nextLine();
        //boolean
        System.out.print("Введіть логічне значення (true/false): ");
        boolean d = Boolean.parseBoolean(scanner.nextLine());

        //msgformat
        String e = "\nТипи даних, які користувач вводив int: {0}, double: {1}, string: {2}, boolean: {3}";
        String f = MessageFormat.format(e, a, b, c, d);
        System.out.println(f);

        System.out.println("\nВивід даних в різних форматах:");

        System.out.println("\nВивід цілих чисел у різних форматах:");

        //8(1)
        System.out.printf("Ціле число(8): %o%n", a);
        //10(2)
        System.out.printf("Ціле число(10): %d%n", a);
        //16?(3)
        System.out.printf("Ціле число (16): %x%n", a);
        //stand.1(4)

        System.out.println("\nВивід чисел з плавачою крапкою у різних форматах:");

        System.out.printf("Число з плаваючою крапкою(станд.): %f%n", b);
        //nauchn(5)
        System.out.printf("Число з плаваючою крапкою(експ.): %e%n", b);
        //16(6)
        System.out.printf("Число з плаваючою крапкою(16): %a%n", b);

        System.out.println("\nВивід строки у різних форматах:");

        //stand.2(7)
        System.out.printf("Строка: %s%n", c);
        //pravo(8)
        System.out.printf("Строка (c): %s%c%n", c,'!');
        //stroka.16(9)
        System.out.printf("Строка(16): %h%n", c);
        //stand.3(10)

        System.out.println("\nВивід логічного значення:");

        System.out.printf("Логічне значення: %b%n", d);

        scanner.close();
    }
}
