/*
 * Class: DataReceiver.java
 * Version: 1.0
 * Date: 2019-04-09
 * Author: Kibaek Yoo
 */

package Controller;

import database.UserView;

import java.util.ArrayList;
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

    public static String getWinningLottoNumbersFromUser(Scanner sc) {
        System.out.println(UserView.COMMENT_WHEN_GET_WINNING_LOTTO_NUMBERS_FROM_USER);
        String winningNumbersFromUser = sc.nextLine();
        while (!Validator.checkWinningLottoNumbers(winningNumbersFromUser)) {
            winningNumbersFromUser = sc.nextLine();
        }
        return winningNumbersFromUser;
    }

    public static int getBonusNumberFromUser(ArrayList<Integer> winningNumberList, Scanner sc) {
        System.out.println(UserView.COMMENT_WHEN_GET_BONUS_NUMBER_FROM_USER);
        String bonusNumberFromUser = sc.nextLine();
        while (!Validator.checkBonusLottoNumberValid(winningNumberList, bonusNumberFromUser)) {
            bonusNumberFromUser = sc.nextLine();
        }

        return Integer.parseInt(bonusNumberFromUser);
    }
}
