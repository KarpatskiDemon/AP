import java.io.*;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.DateTimeException;
import java.util.InputMismatchException;

public class Main {

    public static final int SIZE = 50;
    public static String FNAME = "yes.txt";
    public static LocalDateTime[] data = new LocalDateTime[SIZE];
    public static String[] notates = new String[SIZE];
    public static Scanner s = new Scanner(System.in);
    public static DateTimeFormatter fr = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    public static LocalDateTime datentime;

    public static void addNotate() {
        while (true) {
            System.out.println("Введіть власний формат дати та часу 🙏 : ");
            String usFormat = s.nextLine();

            try {
                fr = DateTimeFormatter.ofPattern(usFormat);
                System.out.println("Введіть дату і час у введеному форматі, або порожній рядок для виходу 🙏 : ");
                String text = s.nextLine();

                if (text.isEmpty()) {
                    System.out.println("Bye... 🎅 ");
                    return;
                }

                datentime = LocalDateTime.parse(text, fr);
                break;
            } catch (DateTimeException e) {
                System.out.println("Помивка 😡🤬 : " + e.getMessage());
            }
        }

        String notate = "";
        System.out.println("Введіть зміст запису(для виходу напишіть : '1234567890098765432112345678900987654321qwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewq') : ");
        while (true) {
            String line = s.nextLine();
            if (line.equals("1234567890098765432112345678900987654321qwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewq")) {
                break;
            } else if (notate.isEmpty()) {
                notate += line;
            } else {
                notate += "\n" + line;
            }

        }

        for (int i = 0; i < SIZE; i++) {
            if (data[i] == null) {
                data[i] = datentime;
                notates[i] = notate;
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
                String dateTimeInput = s.nextLine();

                datentime = LocalDateTime.parse(dateTimeInput, fr);
                break;

            } catch (DateTimeException e) {
                System.out.println("Помивка 😡🤬: " + e.getMessage());
            }
        }

        for (int i = 0; i < SIZE; i++) {
            if (datentime.equals(data[i])) {
                data[i] = null;
                notates[i] = null;
                System.out.println("Запис видалено.🤩 ");
                return;
            }
        }

        System.out.println("Запис не знайдено. ");
    }


    public static void printNotates() {
        for (int i = 0; i < SIZE; i++) {
            if (data[i] != null) {
                System.out.println(data[i].format(fr));
                System.out.println(notates[i]);
                System.out.println();
            }
        }
    }

    public static void wFile() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(FNAME))) {
            for (int i = 0; i < SIZE; i++) {
                if (data[i] != null) {
                    wr.write(data[i].format(fr) + "\n" + notates[i] + "\n");
                }
            }
            System.out.println("Щоденник збережено успішно.");
        } catch (IOException e) {
            System.out.println("Помивка 😡🤬: " + e.getMessage());
        }
    }

    public static void rFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FNAME))) {
            String line;
            int id = 0;
            while ((line = reader.readLine()) != null && id < SIZE) {
                if (line.equals("")) {
                    continue;
                }

                LocalDateTime datetime = LocalDateTime.parse(line, fr);

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
                data[id] = datetime;
                notates[id] = note;
                id = id + 1;
            }
        } catch (IOException | DateTimeException e) {
            System.out.println("Помивка 😡🤬: " + e.getMessage());
        }
    }

    public static void mainmenu() {
        while (true) {
            System.out.println("""
            \n😎😎😎Головне меню😎😎😎
            1. Додати запис
            2. Видалити запис
            3. Переглянути записи
            4. Вихід
            """);

            try {
                int choice = s.nextInt();
                s.nextLine();
                if (choice == 1) {
                    addNotate();
                } else if (choice == 2) {
                    deleteNotate();
                } else if (choice == 3) {
                    printNotates();
                } else if (choice == 4) {
                    System.out.println("Бажаєте зберегти щоденник? (так - 1/ні - 2)");
                    int save = s.nextInt();
                    if (save == 1) {
                        wFile();
                        System.out.println("До побачення!");
                        break;
                    } else if (save == 2) {
                        System.out.println("До побачення!");
                        break;
                    }

                } else {
                    System.out.println("Невірний вибір!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помивка 😡🤬: " + e.getMessage());
                s.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        rFile();
        mainmenu();
    }
}
