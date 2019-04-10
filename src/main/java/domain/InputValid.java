package domain;

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
}
