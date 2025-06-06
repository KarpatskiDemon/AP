package main;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.DateTimeException;


public class MyDiary {


    public static void addNotate() {
        while (true) {
            System.out.println("Введіть власний формат дати та часу 🙏 : ");
            String usFormat = Const.s.nextLine();

            try {
                Const.fr = DateTimeFormatter.ofPattern(usFormat);
                System.out.println("Введіть дату і час у введеному форматі, або порожній рядок для виходу 🙏 : ");
                String text = Const.s.nextLine();

                if (text.isEmpty()) {
                    System.out.println("Bye... 🎅 ");
                    return;
                }

                Const.datentime = LocalDateTime.parse(text, Const.fr);
                break;
            } catch (DateTimeException e) {
                System.out.println("Помивка 😡🤬 : " + e.getMessage());
            }
        }

        String notate = "";
        System.out.println("Введіть зміст запису(для виходу напишіть : '1234567890098765432112345678900987654321qwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewq') : ");
        while (true) {
            String line = Const.s.nextLine();
            if (line.equals("1234567890098765432112345678900987654321qwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewq")) {
                break;
            } else if (notate.isEmpty()) {
                notate += line;
            } else {
                notate += "\n" + line;
            }

        }

        for (int i = 0; i < Const.SIZE; i++) {
            if (Const.data[i] == null) {
                Const.data[i] = Const.datentime;
                Const.notates[i] = notate;
                System.out.println("Запис додано успішно 🤗 ");
                return;
            }
        }

        System.out.println("Щоденник заповнений 🥵 ");
    }

    public static void deleteNotate() {
        while (true) {
            try {
                System.out.println("Введіть дату та час у вашому форматі 😏 : ");
                String dateTimeInput = Const.s.nextLine();

                Const.datentime = LocalDateTime.parse(dateTimeInput, Const.fr);
                break;

            } catch (DateTimeException e) {
                System.out.println("Помивка 😡🤬: " + e.getMessage());
            }
        }

        for (int i = 0; i < Const.SIZE; i++) {
            if (Const.datentime.equals(Const.data[i])) {
                Const.data[i] = null;
                Const.notates[i] = null;
                System.out.println("Запис видалено.🤩 ");
                return;
            }
        }

        System.out.println("Запис не знайдено. ");
    }

    public static void printNotates() {
        for (int i = 0; i < Const.SIZE; i++) {
            if (Const.data[i] != null) {
                System.out.println(Const.data[i].format(Const.fr));
                System.out.println(Const.notates[i]);
                System.out.println();
            }
        }
    }
}
