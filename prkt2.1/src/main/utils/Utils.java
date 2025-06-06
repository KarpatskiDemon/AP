package main.utils;

import java.io.*;
import java.time.LocalDateTime;
import java.time.DateTimeException;
import main.Const;

public class Utils {

    public static void wFile() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(Const.FNAME))) {
            for (int i = 0; i < Const.SIZE; i++) {
                if (Const.data[i] != null) {
                    wr.write(Const.data[i].format(Const.fr) + "\n" + Const.notates[i] + "\n");
                }
            }
            System.out.println("Щоденник збережено успішно.");
        } catch (IOException e) {
            System.out.println("Помивка 😡🤬: " + e.getMessage());
        }
    }
    public static void rFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(Const.FNAME))) {
            String line;
            int id = 0;
            while ((line = reader.readLine()) != null && id < Const.SIZE) {
                if (line.equals("")) {
                    continue;
                }

                LocalDateTime datetime = LocalDateTime.parse(line, Const.fr);

                String note = "";
                while ((line = reader.readLine()) != null) {
                    if (line.equals("")) {
                        break;
                    }
                    if (note.length() > 0) {
                        note += "\n";
                    }
                    note += line;
                }
                Const.data[id] = datetime;
                Const.notates[id] = note;
                id = id + 1;
            }
        } catch (IOException | DateTimeException e) {
            System.out.println("Помивка 😡🤬: " + e.getMessage());
        }
    }
}
