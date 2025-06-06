import java.util.Scanner;

public class n2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//text
        System.out.println("Введіть текст:");
        String txt = scanner.nextLine();
//kilkrech
//while
        int a = 0;
        int b = 0;

        while (b < txt.length()) {
            char cr = txt.charAt(b);
            if (cr == '.' || cr == '!' || cr == '?') {
                a++;
            }
            b++;
        }

        System.out.println("Кількість речень (while): " + a);
//do-while
        int c = 0;
        b = 0;

        do {
            char cr = txt.charAt(b);
            if (cr == '.' || cr == '!' || cr == '?') {
                c++;
            }
            b++;
        } while (b < txt.length());

        System.out.println("Кількість речень (do-while): " + c);

//end
        scanner.close();
    }
}
