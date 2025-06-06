public class n4 {

    public static void main(String[] args) {
        System.out.println("Таблиця синусів від 0 до 90 градусів:");

        for (int i = 0; i <= 90; i++) {
            double sin = Math.sin(Math.toRadians(i));

            //vivid
            System.out.printf("%.5f ", sin);
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}