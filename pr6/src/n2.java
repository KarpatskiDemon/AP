public class n2 {
    public static void main(String[] args) {

        int[] ugli1 = {80, 90, 100, 110};//bagatkut1
        int[] ugli2 = {90, 90, 90, 90};//bagatkut2

        int n1 = ugli1.length; //ugli1
        int n2 = ugli2.length; //ugli2

        int sumauglov1 = 0;//sum1
        int sumauglov2 = 0;//sum2

        for (int ugol1 : ugli1) { //sumpershbagat
            sumauglov1 += ugol1; //sumdrugogobagat
        }

        for (int ugol2 : ugli2) {
            sumauglov2 += ugol2;
        }

        //ugli1
        System.out.println("Перший багатокутник:");
        if (sumauglov1 == 180 * (n1 - 2)) {
            System.out.println("Можна!!!))))))))");
        } else {
            System.out.println("Не можна(((((");
        }

        //ugli2
        System.out.println("Другий багатокутник:");
        if (sumauglov2 == 180 * (n2 - 2)) {
            System.out.println("Можна!!!)))))))))))))))))))))))))))))))");
        } else {
            System.out.println("Не можна(((((");
        }
    }
}