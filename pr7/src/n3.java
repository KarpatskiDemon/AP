import java.util.Scanner;

public class n3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] a = new int[5][5];

        //vedenya
        System.out.println("Введіть елементи матриці 5x5:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        //vivid
        int d = det(a);
        System.out.println("Визначник матриці: " + d);
    }

    //rozrdet
    public static int det(int[][] mat) {
        if (mat.length == 2) {
            return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        } else {
            int d = 0;
            for (int i = 0; i < mat.length; i++) {
                int[][] submat = new int[mat.length - 1][mat.length - 1];
                for (int j = 1; j < mat.length; j++) {
                    for (int k = 0; k < mat.length; k++) {
                        if (k < i) {
                            submat[j - 1][k] = mat[j][k];
                        } else if (k > i) {
                            submat[j - 1][k - 1] = mat[j][k];
                        }
                    }
                }
                d += Math.pow(-1, i) * mat[0][i] * det(submat);
            }
            return d;
        }
    }
}