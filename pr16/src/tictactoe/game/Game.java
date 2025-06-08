package tictactoe.game;

import tictactoe.Const;
import tictactoe.savestncfg.Stats;
import tictactoe.game.CheckWinorDraw;
import java.util.Scanner;


public class Game {
    public static boolean move(char[][] array, int masssize, char currentplayer, Scanner sc) {
        System.out.println("Введіть першу координату : ");
        if (Const.sc.hasNextInt()) {
            int cord1 = Const.sc.nextInt() - 1;
            System.out.println("Введіть другу координату : ");
            if (Const.sc.hasNextInt()) {
                int cord2 = Const.sc.nextInt() - 1;
                cord1 = cord1 * 2;
                cord2 = cord2 * 2;
                if(cord1 > masssize || cord2 > masssize || cord1 < 0 || cord2 < 0) {
                    System.out.println("Ви ввели невірні координати(((");
                    return false;
                } else if (array[cord1][cord2] == ' ') {
                    array[cord1][cord2] = currentplayer;
                    return true;
                } else {
                    System.out.println("Клітинка зайнята, спробуйте ще раз !!))");
                    return false;
                }
            }
        }
        System.out.println("Ви ввели не числове значення, спробуйте ще раз!");
        Const.sc.next();
        return false;
    }

    public static void game(int size) {
        char[][] array = GameField.initializeGameField(size);
        int masssize = array.length;
        int masssize1 = masssize - 2;
        if (size == 9) {
            masssize1 = masssize1 - 2;
        } else if (size == 13) {
            masssize1 = masssize1 - 4;
        } else if (size == 17) {
            masssize1 = masssize1 - 6;
        }
        int c = 0;
        char currentplayer = 'X';
        boolean endgame = false;
        while (!endgame) {
            GameField.displayGameField(array, masssize, masssize1);
            String currentName = (currentplayer == 'X') ? Const.p1Name : Const.p2Name;
            System.out.println("Хід гравця: " + currentName + " (" + currentplayer + ")");
            if (move(array, masssize, currentplayer, Const.sc)) {
                c = c + 1;
                if ((size == 5 && c == 9) || (size == 9 && c == 25) || (size == 13 && c == 49) || (size == 17 && c == 81)) {
                    GameField.displayGameField(array, masssize, masssize1);
                    System.out.println("\nНічия!");
                    Stats.addStats("Нічия");
                    return;
                } else if (CheckWinorDraw.checkWin(array, currentplayer, masssize)) {
                    GameField.displayGameField(array, masssize, masssize1);
                    System.out.println("\nГравець " + currentName + " (" + currentplayer + ") переміг!");
                    Stats.addStats(currentName);
                    return;
                }
                if (currentplayer == 'X') {
                    currentplayer = 'O';
                } else {
                    currentplayer = 'X';
                }
            }
        }
    }
}
