import java.util.Scanner;

public class n1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//1
        System.out.print("Введіть перше число: ");
        double a = scanner.nextDouble();
//2
        System.out.print("Введіть друге число: ");
        double b = scanner.nextDouble();
// Введення операторів
        System.out.print("Введіть оператор (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result;


        switch (operator) {
// +
            case '+':
                result = a + b;
                System.out.println("Результат: " + a + " + " + b + " = " + result);
                break;
// -
            case '-':
                result = a - b;
                System.out.println("Результат: " + a + " - " + b + " = " + result);
                break;
// *
            case '*':
                result = a * b;
                System.out.println("Результат: " + a + " * " + b + " = " + result);
                break;
// /
            case '/':
                if (b != 0) {
                    result = a / b;
                    System.out.println("Результат: " + a + " / " + b + " = " + result);
                } else {
                    System.out.println("Помилка: ділення на нуль.");
                }
                break;
            default:
                System.out.println("Невідомий оператор. Будь ласка, використовуйте +, -, *, /.");
                break;
        }
        scanner.close();
    }
}
