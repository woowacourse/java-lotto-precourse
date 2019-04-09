package userInput;

import domain.Lotto;
import error.Validator;

import java.util.Scanner;

public class BonusBallInput {
    private int bonusNo;

    public BonusBallInput(Lotto winningNumbers) {
        Scanner scan = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = null;
        boolean isAccurate = false;
        while (!isAccurate) {
            input = scan.next();
            isAccurate = validate(input, winningNumbers);
        }
        bonusNo = Integer.parseInt(input);
    }

    private boolean validate(String input, Lotto winningNumbers) {
        Validator validator = new Validator();
        try {
            validator.checkAccuracyOfBonusNo(input, winningNumbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int getBonusNo() {
        return bonusNo;
    }
}
