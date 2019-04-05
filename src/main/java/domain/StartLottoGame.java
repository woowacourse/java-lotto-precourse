package domain;

import java.util.Scanner;

public class StartLottoGame {
    private static final int ONE_LOTTO_PRICE = 1000;

    private int inputCost(Scanner sc){
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }
    public void gameStart(Scanner sc){
        int possibleBuyCnt = (inputCost(sc) / ONE_LOTTO_PRICE);
    }
    public static void main(String[] args){
        StartLottoGame lotto = new StartLottoGame();
        Scanner sc = new Scanner(System.in);
        lotto.gameStart(sc);
    }
}
