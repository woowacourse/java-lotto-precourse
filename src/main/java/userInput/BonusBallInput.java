package userInput;

import error.Validator;

import java.util.Scanner;

public class BonusBallInput {
    private int bonusNo;

    public BonusBallInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = null;
        boolean isAccurate = false;
        while (!isAccurate) {
            input = scan.next();
            isAccurate = validate(input);
        }

    }

    private boolean validate(String input) {
        Validator validator = new Validator();
        try {
            validator.checkAccuracyOfBonusNo(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
