import java.util.Scanner;
import java.util.Random;

public class n5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //sizemass
        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        //createmass
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        System.out.print("Масив: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        //1/2
        System.out.print("Оберіть тип сортування: зростання(1)/спадання(2)(Введіть 1 або 2): ");
        int sortType = scanner.nextInt();

        //perev
        boolean a = true;
        //up
        if (sortType == 1) {
            for (int i = 1; i < size; i++) {
                if (array[i] < array[i - 1]) {
                    a = false;
                    break;
                }
            }
        }
        //down
        else if (sortType == 2) {
            for (int i = 1; i < size; i++) {
                if (array[i] > array[i - 1]) {
                    a = false;
                    break;
                }
            }
        }
        //unluck
        else {
            System.out.println("Неправильний тип сортування(1/2!!!!!!!!!!!!!!!!!!!!!!).");
            return;
        }

        if(a){
            System.out.println("Масив відповадає обраному варіанту");
        }
        else {
            System.out.println("Масив не відповадає обраному варіанту");
        }
    }
}