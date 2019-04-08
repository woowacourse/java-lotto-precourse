package domain;

import error.Validator;

import java.util.Scanner;

public class Purchasing {
    private int price;

    public Purchasing() {
        Scanner scan = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        String input = null;
        boolean isAccurateValue = false;
        while (!isAccurateValue) {
            input = scan.next();
            isAccurateValue = validate(input);
        }
        price = Integer.parseInt(input);
    }

    public Purchasing(int price) {
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
