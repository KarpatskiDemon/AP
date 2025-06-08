package tictactoe.savestncfg;

import java.io.*;
import tictactoe.Const;

public class Config {
    public static void saveConfig(int size, String p1, String p2) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("config.txt"));
            writer.write("size=" + size + "\n" + "player1=" + p1 + "\n" + "player2=" + p2 + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Помивка 😡🤬: " + e.getMessage());
        }
    }

    public static void printConfig(int size, String p1, String p2) {
        System.out.println("\nПоточний розмір поля: " + size + "\n");
        System.out.println("Ім'я першого гравця: " + p1 + "\n");
        System.out.println("Ім'я другого гравця: " + p2);
    }

    public static String[] loadConfig() {
        String[] config = {"5", "Player1", "Player2"};
        try {
            BufferedReader br = new BufferedReader(new FileReader("config.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() >= 5 && line.charAt(0) == 's' && line.charAt(1) == 'i' && line.charAt(2) == 'z' && line.charAt(3) == 'e' && line.charAt(4) == '=') {
                    String value = "";
                    for (int i = 5; i < line.length(); i++) {
                        value += line.charAt(i);
                    }
                    config[0] = value;
                } else if (line.length() >= 8 && line.charAt(0) == 'p' && line.charAt(1) == 'l' && line.charAt(2) == 'a' && line.charAt(3) == 'y' && line.charAt(4) == 'e' && line.charAt(5) == 'r' && line.charAt(6) == '1' && line.charAt(7) == '=') {
                    String value = "";
                    for (int i = 8; i < line.length(); i++) {
                        value += line.charAt(i);
                    }
                    config[1] = value;
                } else if (line.length() >= 8 && line.charAt(0) == 'p' && line.charAt(1) == 'l' && line.charAt(2) == 'a' && line.charAt(3) == 'y' && line.charAt(4) == 'e' && line.charAt(5) == 'r' && line.charAt(6) == '2' && line.charAt(7) == '=') {
                    String value = "";
                    for (int i = 8; i < line.length(); i++) value += line.charAt(i);
                    config[2] = value;
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Помивка 😡🤬: " + e.getMessage());
        }
        try {
            Const.size = Integer.parseInt(config[0]);
        } catch (NumberFormatException e) {
            System.out.println("Помивка 😡🤬: " + e.getMessage());
        }
        Const.size = 5;
        Const.p1Name = config[1];
        Const.p2Name = config[2];
        return config;
    }
}
