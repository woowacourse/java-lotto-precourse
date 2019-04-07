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
        Scanner scanner = new Scanner(System.in);
        int lottoPurchaseMoney = scanner.nextInt();

        return lottoPurchaseMoney;
    }
}
