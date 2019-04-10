package userInput;

import domain.Lotto;
import error.Validator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WinningNumbersInput {
    public static Lotto getWinningNumbers() {
        Scanner scan = new Scanner(System.in);
        System.out.println("지난주 당첨 번호를 입력해 주세요. (','로 숫자 구분)");
        String[] inputs = scan.nextLine().replace(" ", "").split(",");
        while (!validate(inputs)) {
            inputs = scan.nextLine().replace(" ", "").split(",");
        }
        return new Lotto(Arrays.stream(inputs).mapToInt(Integer::parseInt)
                .sorted().boxed().collect(Collectors.toList()));
    }

    private static boolean validate(String[] inputs) {
        Validator validator = new Validator();
        try {
            validator.checkAccuracyOfWinningNumbers(inputs);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
