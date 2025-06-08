package tictactoe.savestncfg;

import java.io.*;
import java.time.LocalDateTime;
import tictactoe.Const;

public class Stats {
    public static void addStats(String winner) {
        if (Const.statsCount < Const.STATS_SIZE) {
            Const.gameDates[Const.statsCount] = LocalDateTime.now();
            Const.winners[Const.statsCount] = winner;
            Const.statsCount = Const.statsCount + 1;
        }
    }

    public static void printStats() {
        if (Const.statsCount == 0) {
            System.out.println("\nСтатистика відсутня!");
            return;
        }
        for (int i = 0; i < Const.statsCount; i++) {
            System.out.println("\nДата та час гри: " + Const.gameDates[i].format(Const.frmtr));
            if (Const.winners[i].equals("Нічия")) {
                System.out.println("Результат : Нічия");
            } else {
                System.out.println("Результат : переміг " + Const.winners[i]);
            }
        }
    }

    public static void saveStats() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(Const.STATS_FILE))) {
            for (int i = 0; i < Const.statsCount; i++) {
                wr.write(Const.gameDates[i].format(Const.frmtr) + "|" + Const.winners[i] + "\n");
            }
            System.out.println("\nСтатистику збережено успішно.");
        } catch (IOException e) {
            System.out.println("Помивка 😡🤬: " + e.getMessage());
        }
    }

    public static void loadStats() {
        Const.statsCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(Const.STATS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null && Const.statsCount < Const.STATS_SIZE) {
                if (line.equals("")) continue;
                int sep = -1;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '|') {
                        sep = i;
                        break;
                    }
                }
                if (sep > 0) {
                    String dateStr = "";
                    for (int i = 0; i < sep; i++) dateStr += line.charAt(i);
                    String winnerStr = "";
                    for (int i = sep + 1; i < line.length(); i++) winnerStr += line.charAt(i);
                    Const.gameDates[Const.statsCount] = LocalDateTime.parse(dateStr, Const.frmtr);
                    Const.winners[Const.statsCount] = winnerStr;
                    Const.statsCount = Const.statsCount + 1;
                }
            }
        } catch (IOException | java.time.DateTimeException e) {
            System.out.println("Помивка 😡🤬: " + e.getMessage());
        }
    }
}
