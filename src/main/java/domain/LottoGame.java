package domain;

import java.util.Scanner;

/**
 * 로또게임을 진행하는 객체
 */
public class LottoGame {

    public LottoGame() {

    }

    public void turnOn() {
        start();
    }

    private void start() {

    }

    private int getLottoPurchaseMoney() {
        String lottoPurchaseMoney;

        do {
            lottoPurchaseMoney = inputLottoPurchaseMoney();
        } while (!isValidLottoPurchaseMoney(lottoPurchaseMoney));

        return Integer.parseInt(lottoPurchaseMoney);
    }

    private String inputLottoPurchaseMoney() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    private boolean isValidLottoPurchaseMoney(String lottoPurchaseMoney) {
        if (!isInteger(lottoPurchaseMoney)) {
            return false;
        }
        if (isNegativeNumber(Integer.parseInt(lottoPurchaseMoney))){
            return false;
        }

        return true;
    }

    private boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }
}
