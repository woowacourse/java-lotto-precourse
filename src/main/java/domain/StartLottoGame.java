package domain;

import java.util.Scanner;

/**
 * 게임 실행을 담당한다.
 */
public class StartLottoGame {
    private static final int ONE_LOTTO_PRICE = 1000;

    public void gameStart(Scanner sc) {
        LottoGame lg = new LottoGame();
        WinningMoney wm = new WinningMoney();
        int resultCost = lg.inputCost(sc);
        lg.buyLotto(resultCost / ONE_LOTTO_PRICE);
        lg.lastWeekNumber(sc);
        lg.matchNumbers(wm);
        wm.printMoneyRate(resultCost);
    }

    public static void main(String[] args) {
        StartLottoGame lotto = new StartLottoGame();
        Scanner sc = new Scanner(System.in);
        lotto.gameStart(sc);
    }
}
