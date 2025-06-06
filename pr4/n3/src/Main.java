import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//poch
        System.out.print("Введіть початковий діапазон: ");
        int poch = scanner.nextInt();
//end
        System.out.print("Введіть кінцевий діапазон: ");
        int end = scanner.nextInt();

        System.out.print("Введіть просте число в діапазоні від 1 до 9: ");
        int diap = scanner.nextInt();

        if (diap < 1 || diap > 9) {
            System.out.println("Будь ласка, введіть просте число від 1 до 9.");
            scanner.close();
            return;
        }
        System.out.println("Числа в діапазоні від " + poch + " до " + end + ", які не кратні " + diap + ":");
        for (int i = poch; i <= end; i++) {
            if (i % diap == 0) {
                continue;
            }
            System.out.println(i);
        }
        scanner.close();
    }
}
