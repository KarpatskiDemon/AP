import java.util.Scanner;


public class n1{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //size
        System.out.print("Введіть розмір піраміди: ");
        int a = Integer.parseInt(scanner.nextLine());

        //stvormass
        int b = 1;
        int[][] pyr = new int[a][];
        for (int i = 0; i < a; i++) {
            pyr[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                pyr[i][j] = b++;
            }
        }

        //vividobi4n
        System.out.println("Піраміда у звичайному порядку: ");
        for (int i = 0; i < pyr.length; i++) {
            for (int k = 0; k < pyr.length - i - 1; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(pyr[i][j] + " ");
            }
            System.out.println();
        }

        //vividnavivorit
        System.out.println("\nПіраміда у зворотньому порядку: ");
        for (int i = pyr.length - 1; i >= 0; i--) {
            for (int k = 0; k < pyr.length - i - 1; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(pyr[i][j] + " ");
            }
            System.out.println();
        }
    }
}