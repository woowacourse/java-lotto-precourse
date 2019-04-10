package userInput;

import domain.Lotto;
import error.Validator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WinningNumbersInput {
    private Lotto winningNumbers;

    public WinningNumbersInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("지난주 당첨 번호를 입력해 주세요. (','로 숫자 구분)");
        String[] inputs = scan.nextLine().replace(" ", "").split(",");
        while (!validate(inputs)) {
            inputs = scan.nextLine().replace(" ", "").split(",");
        }
        winningNumbers = new Lotto(Arrays.stream(inputs).mapToInt(Integer::parseInt)
                .sorted().boxed().collect(Collectors.toList()));
    }

    public WinningNumbersInput(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    private boolean validate(String[] inputs) {
        Validator validator = new Validator();
        try {
            validator.checkAccuracyOfWinningNumbers(inputs);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }
}
