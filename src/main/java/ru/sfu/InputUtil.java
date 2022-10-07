package ru.sfu;

import java.util.Scanner;

/**
 * Input Utility Class
 * @author Agapchenko V.V.
 */
public class InputUtil {

    private final static Scanner scanner = new Scanner(System.in);

    /**
     * Simple Integer input
     * @param message Input invitation
     * @return Inputted Integer
     */
    public static int getInt(String message) {
        return nextIntCheckCycle(message);
    }


    /**
     * Integer input in the boundaries
     * @param message Input invitation
     * @param leftBorder Left border of boundaries
     * @param rightBorder Right border of boundaries
     * @return Inputted Integer
     */
    public static int getInt(String message, int leftBorder, int rightBorder) {
        int number;
        while (true) {
            number = nextIntCheckCycle(message);
            if (leftBorder <= number && number <= rightBorder) break;
            System.out.println("Wrong input");
        }
        return number;
    }

    /**
     * Check if String is an Integer
     * @param string String to check
     * @return Check result
     */
    private static boolean isInteger(String string) {
        int radix = 10;
        for (int i = 0; i < string.length(); i++) {
            if (i == 0 && string.charAt(i) == '-') {
                if (string.length() == 1) return false;
                else continue;
            }
            if (Character.digit(string.charAt(i), radix) < 0)
                return false;
        }
        return true;
    }

    /**
     * Cyclic method to get input data from the scanner
     * and check that it is an Integer
     * @param message Input invitation
     * @return Inputted Integer
     */
    private static int nextIntCheckCycle(String message) {
        String line;
        int integer;
        while (true) {
            System.out.print(message);
            line = scanner.nextLine();
            if (line.isEmpty()) {
                System.out.println("Input is empty");
                continue;
            }
            if (!isInteger(line)) {
                System.out.println("Input is not an integer");
                continue;
            }
            integer = Integer.parseInt(line);
            return integer;
        }
    }

    /**
     * Simple String input
     * @param message Input invitation
     * @return Inputted String
     */
    public static String getString(String message) {
        String line;
        while (true) {
            System.out.print(message);
            line = scanner.nextLine();
            if (line.isEmpty()) {
                System.out.println("Input is empty");
                continue;
            }
            return line;
        }
    }
}
