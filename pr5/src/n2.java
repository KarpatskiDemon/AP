import java.util.Scanner;
import java.lang.Math;


public class n2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input

        //a
        System.out.print("Введіть знач. a: ");
        double a = scanner.nextDouble();

        //b
        System.out.print("Введіть знач. b: ");
        double b = scanner.nextDouble();

        //x
        System.out.print("Введіть знач. x: ");
        double x = scanner.nextDouble();

        //poch
        double func = 0;

        //1usl
        if (x < 7) {
            double z = Math.pow(x, 3) + a;
            double koren = Math.sqrt(z);
            if (z >= 0) {
                func = koren;
            } else {
                System.out.println("Недопустиме значення, підкоренний вираз менше 0 ");
                return;
            }
        }
        //2usl
        else if (x == 7){
            func = -b * x - 3;
        }
        //3usl
        else if (7 < x && x < 10) {
            func = Math.sin(x);
        }
        //x o4en` bolshoi
        else {
            System.out.println("x недопустиме значення(вище за допустимий діапазон)");
            return;
        }
        //vivid
        System.out.println("f(x) = " + func);

        scanner.close();
    }
}