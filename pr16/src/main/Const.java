package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Const {
    public static final int SIZE = 50;
    public static String FNAME = "yes.txt";
    public static LocalDateTime[] data = new LocalDateTime[SIZE];
    public static String[] notates = new String[SIZE];
    public static Scanner s = new Scanner(System.in);
    public static DateTimeFormatter fr = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    public static LocalDateTime datentime;
}

