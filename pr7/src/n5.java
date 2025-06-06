import java.util.Scanner;
import java.util.Random;

public class n5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //size
        System.out.print("Введіть розмір квадратної матриці : ");
        int a = scanner.nextInt();

        //stvormat
        int[][] mat = new int[a][a];
        System.out.println("Mатриця:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                mat[i][j] = random.nextInt(1000);
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        //tranfsdgponuvanya
        int[][] mat1 = new int[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                mat1[j][i] = mat[i][j];
            }
        }

        //vividtrans
        System.out.println("Транспонована матриця:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print(mat1[i][j] + " ");
            }
            System.out.println();
        }
    }
}