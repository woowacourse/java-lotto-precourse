package domain;

import java.util.Scanner;

public class Util {
    private static Scanner sc = new Scanner(System.in);

    public static void printConsole(String message) {
        System.out.println(message);
    }

    public static String getConsoleInput() {
        return sc.nextLine();
    }

    public static Integer fromStringToInteger(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch(Exception ex) {
            throw ex;
        }
    }

    public static String removeBlank(String inputString){
        return inputString.replace(" ", "");
    }

    public static int divideThousand(int number){
        return number /1000;
    }
}
