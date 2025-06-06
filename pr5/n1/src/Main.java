import java.lang.Math;
import java.rmi.StubNotFoundException;

public class Main {
    public static void main(String[] args) {
        // const
        double a = 0.816;
        double b = 3.4;
        double c = 16.7;

        //x
        double x = Math.pow(a,3)*Math.pow(Math.atan(Math.pow((a + b),2)),2) + (c)/(Math.sqrt(a + b));

        //y
        double y1 = a * c;
        double y2 = Math.E;
        double  y = (b * Math.pow(a,2) - c)/(Math.pow(y2,y1) - 1);

        //vivid
        System.out.printf("x = %.2f%n", x);
        System.out.printf("y = %.2f%n", y);
        }
    }

