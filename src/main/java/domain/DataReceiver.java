package domain;

import java.util.Scanner;

public class DataReceiver {

    public static int getInputMoneyFromUser(Scanner sc) {
        String inputMoneyFromUser = sc.nextLine();
        while (!Validator.checkInputLottoMoney(inputMoneyFromUser)) {
            inputMoneyFromUser = sc.nextLine();
        }

        int inputMoney = Integer.parseInt(inputMoneyFromUser);
        return inputMoney;
    }
}
