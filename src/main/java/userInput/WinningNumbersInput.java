package userInput;

import error.Validator;

import java.util.List;
import java.util.Scanner;

public class WinningNumbersInput {
    private List<Integer> numbers;

    public WinningNumbersInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("지난주 당첨 번호를 입력해 주세요.");
        String input = null;
        boolean isAccurate = false;
        while (!isAccurate) {
            input = scan.next();
            isAccurate = validate(input);
        }

    }

    public WinningNumbersInput(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private boolean validate(String input) {
        Validator validator = new Validator();
        try {
            validator.checkAccuracyOfWinningNumbers(input.split(","));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
