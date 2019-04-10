package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputValid {
    Scanner sc;

    InputValid(Scanner sc) {
        this.sc = sc;
    }

    public int checkMoney(String money) {
        Result result = isValidMoney(money);

        while (!result.isValid()) {
            result.printErrorMessage(Message.INPUT_MONEY_MESSAGE);
            money = sc.nextLine();
            result = isValidMoney(money);
        }

        return Integer.parseInt(money);
    }

    private Result isValidMoney(String money) {
        if (Valid.isInputHasChar(new String[]{money})) {
            return Result.fail(Message.INPUT_HAS_CHAR);
        }
        if (Valid.isMinusInput(money)) {
            return Result.fail(Message.MINUS_INPUT);
        }
        if (Valid.isOneMoreInput(money)) {
            return Result.fail(Message.ONE_MORE_INPUT);
        }
        if (Valid.isRemainder(Integer.parseInt(money))) {
            return Result.fail(Message.MONEY_HAS_REMAINDER);
        }
        return Result.ok();
    }

    public Lotto checkWinningNumbers(String winningNumbers) {
        Result result = isValidWinningNumbers(winningNumbers);
        while (!result.isValid()) {
            result.printErrorMessage(Message.INPUT_WIN_MESSAGE);
            winningNumbers = sc.nextLine();
            result = isValidWinningNumbers(winningNumbers);
        }

        List<Integer> list = new ArrayList<>();
        new ArrayList<>(Arrays.asList(winningNumbers.split(Message.SPOT))).forEach(r -> list.add(Integer.parseInt(r)));
        return new Lotto(list);
    }
}
