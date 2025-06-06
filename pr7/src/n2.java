import java.util.Random;
import java.util.Scanner;

public class n2 {

    public static void main(String[] args) {
        //scanneri
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        //size
        System.out.print("Введіть кількість рядків: ");
        int a = Integer.parseInt(scanner1.nextLine());
        System.out.print("Введіть кількість колонок: ");
        int b = Integer.parseInt(scanner2.nextLine());

        //stvormass
        double[][] array = new double[a][b];
        Random r = new Random();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                array[i][j] = r.nextDouble() * 999;
            }
        }

        //vividdo
        System.out.println("Масив до заміни:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.printf("%.2f; ", array[i][j]);
            }
            System.out.println();
        }

        //change
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i % 2 != 0 || j % 2 != 0) {
                    array[i][j] = Math.sqrt(array[i][j]);
                }
            }
        }

        //vividpislya
        System.out.println("Масив після заміни:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.printf("%.2f; ", array[i][j]);
            }
            System.out.println();
        }
    }
}