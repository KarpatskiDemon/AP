import java.util.Random;

public class n1 {
    //dlinamassiva
    public static final int len = 16;

    public static void main(String[] args) {
        //createmass
        int[] a = new int[len];
        Random random = new Random();

        int p = 0;//parne
        int np = 0;//noparne

        //genzna4
        for (int i = 0; i < len; i++) {
            a[i] = random.nextInt(999);
            System.out.print(a[i] + " ");
        }

        //parne/noparne
        for (int d : a) {
            if (d % 2 == 0) {
                p = p + 1;
            }
            else if (d % 2 == 1){
                np = np + 1;
            }
        }
        //vivid
        System.out.printf("%n Кількість парних чисел: " + p);
        System.out.printf("%n Кількість непарних чисел: " + np);
    }
}