package domain.util;

import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInteger() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("정수를 입력하세요");
            return getInteger();
        }
    }

    public static String getString() {
        return scanner.nextLine();
    }
}
