package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class DataReceiver {

    static final String COMMENT_WHEN_GET_WINNING_LOTTO_NUMBERS_FROM_USER = "지난 주 당첨 번호를 입력해주세요.";
    static final String COMMENT_WHEN_GET_BONUS_NUMBER_FROM_USER = "보너스 볼을 입력해 주세요.";

    public static int getInputMoneyFromUser(Scanner sc) {
        String inputMoneyFromUser = sc.nextLine();
        while (!Validator.checkInputLottoMoney(inputMoneyFromUser)) {
            inputMoneyFromUser = sc.nextLine();
        }

        int inputMoney = Integer.parseInt(inputMoneyFromUser);
        return inputMoney;
    }

    public static ArrayList<Integer> getWinningLottoNumbersFromUser(Scanner sc) {
        System.out.println(COMMENT_WHEN_GET_WINNING_LOTTO_NUMBERS_FROM_USER);
        String winningNumbersFromUser = sc.nextLine();
        while (!Validator.checkWinningLottoNumbers(winningNumbersFromUser)) {
            winningNumbersFromUser = sc.nextLine();
        }
        ArrayList<Integer> winningNumbers = transformWinningNumberInputToIntegerList(winningNumbersFromUser);
        return winningNumbers;
    }

    private static ArrayList<Integer> transformWinningNumberInputToIntegerList(String winningNumbersInput) {
        String[] correctNumbers = winningNumbersInput.split(",");
        ArrayList<Integer> winningNumbers = new ArrayList<Integer>();
        for (int i = 0; i < correctNumbers.length; i++) {
            winningNumbers.add(Integer.parseInt(correctNumbers[i]));
        }
        return winningNumbers;
    }

    public static int getBonusNumberFromUser(ArrayList<Integer> winningNumberList, Scanner sc) {
        System.out.println(COMMENT_WHEN_GET_BONUS_NUMBER_FROM_USER);
        String bonusNumberFromUser = sc.nextLine();
        while (!Validator.checkBonusLottoNumberValid(winningNumberList, bonusNumberFromUser)) {
            bonusNumberFromUser = sc.nextLine();
        }

        return Integer.parseInt(bonusNumberFromUser);
    }
}
