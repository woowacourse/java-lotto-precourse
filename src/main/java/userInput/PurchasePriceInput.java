package userInput;

import error.Validator;

import java.util.Scanner;

public class PurchasePriceInput {
    private int price;

    public PurchasePriceInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        String input = scan.nextLine().trim();
        while (!validate(input)) {
            input = scan.nextLine().trim();
        }
        price = Integer.parseInt(input);
    }

    public PurchasePriceInput(int price) {
        this.price = price;
    }

    private boolean validate(String input) {
        Validator validator = new Validator();
        try {
            validator.checkAccuracyOfPurchasePrice(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int getPrice() {
        return price;
    }
}
