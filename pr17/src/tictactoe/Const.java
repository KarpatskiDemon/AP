package tictactoe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Const {
    public static DateTimeFormatter frmtr = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static Scanner sc = new Scanner(System.in);
    public static String p1Name = "Player1";
    public static String p2Name = "Player2";
    public static String STATS_FILE = "stats.txt";
    public static final int STATS_SIZE = 100;
    public static int statsCount = 0;
    public static LocalDateTime[] gameDates = new LocalDateTime[STATS_SIZE];
    public static String[] winners = new String[STATS_SIZE];
    public static int size = 5;
}
