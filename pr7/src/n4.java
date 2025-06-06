import java.util.Scanner;
import java.util.Random;

public class n4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //size
        System.out.print("Введіть кількість рядків: ");
        int a = scanner.nextInt();
        System.out.print("Введіть кількість стовпців: ");
        int b = scanner.nextInt();

        //createmat
        int[][] mat = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                mat[i][j] = random.nextInt(1000);
            }
        }

        //vividistvmat
        if (a < 2 || b < 2) {
            System.out.println("Подумайте ще(інтерактив: визначте помилку без підказок)");
        }
        else {
            System.out.println("Згенерована матриця:");
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        }

        System.out.print("Введіть номер рядка для обчислення мінора : ");
        int a2 = scanner.nextInt() - 1;
        System.out.print("Введіть номер стовпця для обчислення мінора : ");
        int b2 = scanner.nextInt() - 1;

        //vividiob4minora
        int[][] subMatrix = mat1(mat, a2, b2);
        int minor = minor(subMatrix);
        System.out.println("Мінор матриці: " + minor);
    }

    //submat
    public static int[][] mat1(int[][] mat, int a2, int b2) {
        int a = mat.length;
        int b = mat[0].length;
        int[][] mat1 = new int[a - 1][b - 1];

        int a1 = 0;
        for (int i = 0; i < a; i++) {
            if (i == a2) continue;
            int b1 = 0;
            for (int j = 0; j < b; j++) {
                if (j == b2) continue;
                mat1[a1][b1] = mat[i][j];
                b1++;
            }
            a1++;
        }
        return mat1;
    }

    //ob4minora
    public static int minor(int[][] mat) {
        int a = mat.length;

        if (a == 2) {
            return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        }
        int m = 0;
        for (int b = 0; b < a; b++) {
            int[][] mat1 = mat1(mat, 0, b);
            m += Math.pow(-1, b) * mat[0][b] * minor(mat1);
        }
        return m;
    }
}