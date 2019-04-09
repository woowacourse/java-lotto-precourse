package userInput;

import error.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WinningNumbersInput {
    private List<Integer> numbers;

    public WinningNumbersInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("지난주 당첨 번호를 입력해 주세요. (','로 숫자 구분)");
        String[] inputs = null;
        boolean isAccurate = false;
        while (!isAccurate) {
            inputs = scan.next().split(",");
            isAccurate = validate(inputs);
        }
        numbers = Arrays.stream(inputs).mapToInt(Integer::parseInt)
                .sorted()
                .boxed().collect(Collectors.toList());
    }

    public WinningNumbersInput(List<Integer> numbers) {
        this.numbers = numbers;
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

    public List<Integer> getNumbers() {
        return numbers;
    }
}
