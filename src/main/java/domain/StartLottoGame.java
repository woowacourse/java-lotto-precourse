package domain;

import java.util.Scanner;

/**
 * 게임 실행을 담당한다.
 */
public class StartLottoGame {
    private static final int ONE_LOTTO_PRICE = 1000;

    public void gameStart() {
        LottoGame lg = new LottoGame();
        Scanner sc = new Scanner(System.in);
        int possibleBuyCnt = (lg.inputCost(sc) / ONE_LOTTO_PRICE);
        lg.buyLotto(possibleBuyCnt);
        lg.lastWeekNumber(sc);
        lg.matchNumbers();
    }

    public static void main(String[] args) {
        StartLottoGame lotto = new StartLottoGame();
        lotto.gameStart();
    }
}
