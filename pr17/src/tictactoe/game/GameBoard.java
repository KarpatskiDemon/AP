package tictactoe.game;

public class GameBoard {
    public char[][] board;
    public int size;
    
    public GameBoard(int size) {
        this.size = size;
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i % 2 == 1) {
                    board[i][j] = '-';
                } else if (j % 2 == 1) {
                    board[i][j] = '|';
                } else {
                    board[i][j] = ' ';
                }
            }
        }
    }
    
    public void display(int masssize1) {
        System.out.println("\nВаше поле:");
        System.out.print(" ");
        for (int i = 0; i < masssize1; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                System.out.print(i / 2 + 1);
            } else {
                System.out.print(" ");
            }
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
} 