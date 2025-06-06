import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.DateTimeException;

public class Main {

    public static final int SIZE = 50;
    public static LocalDateTime[] data = new LocalDateTime[SIZE];
    public static String[] notates = new String[SIZE];

    public static void addNotate(){
        Scanner s = new Scanner(System.in);

        LocalDateTime date;
        while(true) {
            try {
                System.out.println("Введіть дату для запису(рік, місяць, число😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡): ");
                date = LocalDateTime.of(s.nextInt(), s.nextInt(), s.nextInt(), 0, 0);
                s.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Помивка😡: " + e.getMessage());
                s.nextLine();
            } catch (DateTimeException e) {
                System.out.println("Помивка😡: " + e.getMessage());
                s.nextLine();
            }
        }

        String notate = "";
        String line;
        System.out.println("Введіть зміст нотатки(для виходу натисніть 1234567890098765432112345678900987654321qwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewq): ");

        while(true) {
            line = s.nextLine();
            if(line.equals("1234567890098765432112345678900987654321qwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewq")){
                break;
            }
            if (notate.length() == 0) {
                notate = line;
            } else {
                notate = notate + "\n" + line;
            }
        }


        for (int i = 0; i < SIZE; i++) {
            if(data[i] == null){
                data[i] = date;
                notates[i] = notate;
                System.out.println("Вміст успішно записано🤗");
                break;
            } else if(i == SIZE){
                System.out.println("Щоденник вже наповнений до кінця 🥵🥵🥵");
            }
        }
    }

    public static void deleteNotate(){
        Scanner s = new Scanner(System.in);
        LocalDateTime date;
        while (true) {
            try {
                System.out.println("Введіть дату для видалення нотатки(рік, місяць, число😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡😡): ");
                date = LocalDateTime.of(s.nextInt(), s.nextInt(), s.nextInt(), 0, 0);
                s.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Помивка😡: " + e.getMessage());
                s.nextLine();
            } catch (DateTimeException e) {
                System.out.println("Помивка😡: " + e.getMessage());
                s.nextLine();
            }
        }

        boolean found = false;
        for (int i = 0; i < SIZE; i++) {
            if(date.equals(data[i])){
                data[i] = null;
                notates[i] = null;
                System.out.println("Запис за датою " + date + " успішно видалено");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Запису за заданою датою не знайдено, спробуйте ще раз");
        }
    }

    public static void printNotates(){
        for(int i = 0; i < SIZE; i++){
            if(data[i] != null){
                System.out.println(data[i] + " : ");
                System.out.println(notates[i]);
                System.out.println();
            }
        }
    }

    public static void mainmenu(){
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("""
            \n😎😎😎Головне меню😎😎😎
            
            1.Додати запис😍
            2.Видалити запис🙄
            3.Переглянути запис😏
            4.Вихід😴🥱
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
                    System.out.println("Вихід((((😅😅😥😥😪😪😭😭");
                    break;
                } else {
                    System.out.println("Невірний вибір! Спробуйте ще раз!((😡😡😡");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помивка😡: " + e.getMessage());
                s.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        mainmenu();
    }
}