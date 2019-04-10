package userInput;

import domain.Lotto;
import error.Validator;

import java.util.Scanner;

public class BonusBallInput {
    public static int getBonusBall(Lotto winningNumbers) {
        Scanner scan = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scan.nextLine().trim();
        while (!validate(input, winningNumbers)) {
            input = scan.nextLine().trim();
        }
        return Integer.parseInt(input);
    }

    private static boolean validate(String input, Lotto winningNumbers) {
        Validator validator = new Validator();
        try {
            validator.checkAccuracyOfBonusNo(input, winningNumbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
