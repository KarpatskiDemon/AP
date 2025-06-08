package tictactoe.game;

public class CheckWinorDraw {
    public static boolean checkWin(char[][] array, char lastplayer, int masssize) {
        for (int i = 0; i < masssize; i += 2) {
            for (int j = 0; j < masssize - 4; j += 2) {
                if (array[i][j] == lastplayer && array[i][j + 2] == lastplayer && array[i][j + 4] == lastplayer) {
                    return true;
                }
            }
        }
        for (int i = 0; i < masssize - 4; i += 2) {
            for (int j = 0; j < masssize; j += 2) {
                if (array[i][j] == lastplayer && array[i + 2][j] == lastplayer && array[i + 4][j] == lastplayer) {
                    return true;
                }
            }
        }
        for (int i = 0; i < masssize - 4; i += 2) {
            for (int j = 0; j < masssize - 4; j += 2) {
                if (array[i][j] == lastplayer && array[i + 2][j + 2] == lastplayer && array[i + 4][j + 4] == lastplayer) {
                    return true;
                }
            }
        }
        for (int i = 0; i < masssize - 4; i += 2) {
            for (int j = 4; j < masssize; j += 2) {
                if (array[i][j] == lastplayer && array[i + 2][j - 2] == lastplayer && array[i + 4][j - 4] == lastplayer) {
                    return true;
                }
            }
        }
        return false;
    }
}
