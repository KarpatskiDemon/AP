import java.util.Scanner;
import java.util.Random;

public class n3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        //size
        System.out.print("Введіть розмір масиву: ");
        int a = scanner.nextInt();

        int[] array = new int[a];

        System.out.println("Масив :");

        //createmass
        for (int i = 0; i < a; i++) {
            array[i] = r.nextInt(1000);
            System.out.print(array[i] + " ");
        }

        System.out.printf("%nВведіть значення, яке потрібно знайти: ");
        int start = scanner.nextInt();

        System.out.print("Введіть нове значення: ");
        int finish = scanner.nextInt();

        //perev
        boolean b = false;
        for (int i = 0; i < a; i++) {
            if (array[i] == start) {
                array[i] = finish;
                b = true;
                break;
            }
        }

        if (b) {
            System.out.println("Значення успішно замінено!!!!!!");
            System.out.println("Оновлений масив:");
            for (int i = 0; i < a; i++) {
                System.out.print(array[i] + " ");
            }
        }
        else {
            System.out.println("Значення не знайдено в масиві.");
        }
    }
}