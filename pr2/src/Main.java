import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printdatatypes();
        Scanner scanner = new Scanner(System.in);
        //int
        System.out.println("Введіть ціле число (int): ");
        String intInput = scanner.nextLine();
        try {
            int intValue = Integer.parseInt(intInput);
            System.out.println("Введений int: " + intValue);
        } catch (NumberFormatException e) {
            System.out.println("Неправильний формат для int.");
        }
        //double
        System.out.println("Введіть число з плаваючою точкою (double): ");
        String doubleInput = scanner.nextLine();
        try {
            double doubleValue = Double.parseDouble(doubleInput);
            System.out.println("Введений double: " + doubleValue);
        } catch (NumberFormatException e) {
            System.out.println("Неправильний формат для double.");
        }
        //short
        System.out.println("Введіть коротке число (short): ");
        String shortInput = scanner.nextLine();
        try {
            short shortValue = Short.parseShort(shortInput);
            System.out.println("Введений short: " + shortValue);
        } catch (NumberFormatException e) {
            System.out.println("Неправильний формат для short.");
        }
        //long
        System.out.println("Введіть довге число (long): ");
        String longInput = scanner.nextLine();
        try {
            long longValue = Long.parseLong(longInput);
            System.out.println("Введений long: " + longValue);
        } catch (NumberFormatException e) {
            System.out.println("Неправильний формат для long.");
        }
        //float
        System.out.println("Введіть число з плаваючою точкою (float): ");
        String floatInput = scanner.nextLine();
        try {
            float floatValue = Float.parseFloat(floatInput);
            System.out.println("Введений float: " + floatValue);
        } catch (NumberFormatException e) {
            System.out.println("Неправильний формат для float.");
        }
        //char
        System.out.println("Введіть символ (char): ");
        String charInput = scanner.nextLine();
        if (charInput.length() == 1) {
            char charValue = charInput.charAt(0);
            System.out.println("Введений char: " + charValue);
        } else {
            System.out.println("Це не символ.");
        }
        //boolean
        System.out.println("Введіть бульове знач. (true/false): ");
        String booleanInput = scanner.nextLine();
        boolean booleanValue = Boolean.parseBoolean(booleanInput);
        System.out.println("Введений boolean: " + booleanValue);
        scanner.close();
    }
    //Інформація про примітивні типи даних
    public static void printdatatypes() {
        System.out.println("Інформація про примітивні типи в Java:");
        System.out.printf("%-10s | %-10s | %-20s | %-20s%n", "Тип", "Розмір (байти)", "Мін. знач.", "Макс. знач.");
        System.out.printf("%-10s | %-10d | %-20d | %-20d%n", "byte", 1, Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("%-10s | %-10d | %-20d | %-20d%n", "short", 2, Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("%-10s | %-10d | %-20d | %-20d%n", "int", 4, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("%-10s | %-10d | %-20d | %-20d%n", "long", 8, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.printf("%-10s | %-10d | %-20s | %-20s%n", "float", 4, Float.MIN_VALUE, Float.MAX_VALUE);
        System.out.printf("%-10s | %-10d | %-20s | %-20s%n", "double", 8, Double.MIN_VALUE, Double.MAX_VALUE);
        System.out.printf("%-10s | %-10d | %-20s | %-20s%n", "char", 2, Character.MIN_VALUE, Character.MAX_VALUE);
        System.out.printf("%-10s | %-10s | %-20s | %-20s%n", "boolean", 1, "false", "true");
    }
}
