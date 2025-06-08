package tictactoe.game;

public class GameField {
    public static char[][] initializeGameField(int size) {
        char[][] array = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i % 2 == 1) {
                    array[i][j] = '-';
                } else if (j % 2 == 1) {
                    array[i][j] = '|';
                } else {
                    array[i][j] = ' ';
                }
            }
        }
        return array;
    }

    public static void displayGameField(char[][] array, int masssize, int masssize1) {
        System.out.println("\nВаше поле:");
        System.out.print(" ");
        for (int i = 0; i < masssize1; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < masssize; i++) {
            if (i % 2 == 0) {
                System.out.print(i / 2 + 1);
            } else {
                System.out.print(" ");
            }
            for (int j = 0; j < masssize; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
