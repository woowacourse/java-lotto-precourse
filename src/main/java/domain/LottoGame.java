package domain;

import java.util.Scanner;

public class LottoGame {

    private static final String MESSAGE_INPUT_MONEY = "구매금액 입력";

    private int inputMoney() {
        Scanner scan = new Scanner(System.in);
        String input;
        do {
            System.out.println(MESSAGE_INPUT_MONEY);
            input = scan.nextLine();
        }
        while (!Validation.isValidInputMoney(input));
        return Integer.parseInt(input);
    }


}
