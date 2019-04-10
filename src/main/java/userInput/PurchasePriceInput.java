package userInput;

import error.Validator;

import java.util.Scanner;

public class PurchasePriceInput {
    public static int takeMoney() {
        Scanner scan = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        String input = scan.nextLine().trim();
        while (!validate(input)) {
            input = scan.nextLine().trim();
        }
        return Integer.parseInt(input);
    }

    private static boolean validate(String input) {
        Validator validator = new Validator();
        try {
            validator.checkAccuracyOfPurchasePrice(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
