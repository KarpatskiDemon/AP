import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 5;
        while (true) {
            int choice = MainMenu(scanner);
            if (choice == 1) {
                Game(size, scanner);
            } else if (choice == 2) {
                int newSize = Settings(scanner);
                if (newSize != -1) {
                    size = newSize;
                    System.out.println("Розмір поля змінено!");
                }
            } else if (choice == 3) {
                System.out.println("Ви обрали вихід!");
                return;
            } else {
                System.out.println("Щось не те, спробуйте ще раз!");
            }
        }
    }

    private static int MainMenu(Scanner scanner) {
        String menu = """
                1. Грати(Нова гра)
                2. Налаштування
                3. Вихід""";
        System.out.println(menu);
        System.out.print("Сюди : ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        }
        scanner.nextLine();
        return -1;
    }

    private static int Settings(Scanner scanner) {
        System.out.println("Ви обрали налаштування!");
        while (true) {
            System.out.println("""
                    Оберіть розмір поля :
                    1. 3x3
                    2. 5x5
                    3. 7x7
                    4. 9x9
                    5. Головне меню""");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                int size = -1;
                if (choice == 1) {
                    size = 5;
                } else if (choice == 2) {
                    size = 9;
                } else if (choice == 3) {
                    size = 13;
                } else if (choice == 4) {
                    size = 17;
                } else if (choice == 5) {
                    size = -1;
                } else {
                    System.out.println("Немає такого (( (правильно буде число від 1 до 5)");
                }
                if (size != -1 || choice == 5) {
                    return size;
                }
            } else {
                System.out.println("Ви ввели не число! Спробуйте ще раз.");
                scanner.nextLine();
            }
        }
    }

    private static char[][] InitializeGameField(int size) {
        char[][] array = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i % 2 == 1) {
                    array[i][j] = '-';
                } else if (j % 2 == 1) {
                    array[i][j] = '|';
                } else {
                    array[i][j] = ' ';
                }
            }
        }
        return array;
    }

    private static void DisplayGameField(char[][] array, int masssize, int masssize1) {
        System.out.println("Ваше поле:");
        System.out.print(" ");
        for (int i = 0; i < masssize1; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < masssize; i++) {
            if (i % 2 == 0) {
                System.out.print(i / 2 + 1);
            } else {
                System.out.print(" ");
            }
            for (int j = 0; j < masssize; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean Move(char[][] array, int masssize, char currentplayer, Scanner scanner) {
        System.out.println("Введіть першу координату : ");
        if (scanner.hasNextInt()) {
            int cord1 = scanner.nextInt() - 1;
            System.out.println("Введіть другу координату : ");
            if (scanner.hasNextInt()) {
                int cord2 = scanner.nextInt() - 1;
                cord1 = cord1 * 2;
                cord2 = cord2 * 2;
                if(cord1 > masssize || cord2 > masssize || cord1 < 0 || cord2 < 0) {
                    System.out.println("Ви ввели невірні координати(((");
                    return false;
                } else if (array[cord1][cord2] == ' ') {
                    array[cord1][cord2] = currentplayer;
                    return true;
                } else {
                    System.out.println("Клітинка зайнята, спробуйте ще раз !!))");
                    return false;
                }
            }
        }
        System.out.println("Ви ввели не числове значення, спробуйте ще раз!");
        scanner.next();
        return false;
    }

    private static void Game(int size, Scanner scanner) {
        char[][] array = InitializeGameField(size);
        int masssize = array.length;
        int masssize1 = masssize - 2;
        if (size == 9) {
            masssize1 = masssize1 - 2;
        } else if (size == 13) {
            masssize1 = masssize1 - 4;
        } else if (size == 17) {
            masssize1 = masssize1 - 6;
        }
        int c = 0;
        char currentplayer = 'X';
        boolean endgame = false;
        while (!endgame) {
            DisplayGameField(array, masssize, masssize1);
            if (Move(array, masssize, currentplayer, scanner)) {
                c = c + 1;
                if ((size == 5 && c == 9) || (size == 9 && c == 25) || (size == 13 && c == 49) || (size == 17 && c == 81)) {
                    DisplayGameField(array, masssize, masssize1);
                    System.out.println("Нічия!");
                    return;
                } else if (CheckWin(array, currentplayer, masssize)) {
                    DisplayGameField(array, masssize, masssize1);
                    System.out.println("Гравець " + currentplayer + " переміг!");
                    return;
                }
                if (currentplayer == 'X') {
                    currentplayer = 'O';
                } else {
                    currentplayer = 'X';
                }
            }
        }
    }

    private static boolean CheckWin(char[][] array, char lastplayer, int masssize) {
        for (int i = 0; i < masssize; i += 2) {
            for (int j = 0; j < masssize - 4; j += 2) {
                if (array[i][j] == lastplayer && array[i][j + 2] == lastplayer && array[i][j + 4] == lastplayer) {
                    return true;
                }
            }
        }
        for (int i = 0; i < masssize - 4; i += 2) {
            for (int j = 0; j < masssize; j += 2) {
                if (array[i][j] == lastplayer && array[i + 2][j] == lastplayer && array[i + 4][j] == lastplayer) {
                    return true;
                }
            }
        }
        for (int i = 0; i < masssize - 4; i += 2) {
            for (int j = 0; j < masssize - 4; j += 2) {
                if (array[i][j] == lastplayer && array[i + 2][j + 2] == lastplayer && array[i + 4][j + 4] == lastplayer) {
                    return true;
                }
            }
        }
        for (int i = 0; i < masssize - 4; i += 2) {
            for (int j = 4; j < masssize; j += 2) {
                if (array[i][j] == lastplayer && array[i + 2][j - 2] == lastplayer && array[i + 4][j - 4] == lastplayer) {
                    return true;
                }
            }
        }
        return false;
    }
}