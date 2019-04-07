package domain;

import ExceptionCheck.NoticeOfException;

import java.util.Scanner;

/**
 * 게임 실행을 담당한다.
 */
public class StartLottoGame {
    private static final int ONE_LOTTO_PRICE = 1000;

    public void gameStart(NoticeOfException noe) {
        LottoGame lg = new LottoGame();
        WinningMoney wm = new WinningMoney();
        Scanner sc = new Scanner(System.in);
        int resultCost = lg.inputCost(sc, noe);
        int possibleBuyCnt = (resultCost / ONE_LOTTO_PRICE);
        lg.buyLotto(possibleBuyCnt);
        lg.lastWeekNumber(sc);
        lg.matchNumbers(wm);
        wm.printMoneyRate(resultCost);
    }

    public static void main(String[] args) {
        StartLottoGame lotto = new StartLottoGame();
        NoticeOfException noe = new NoticeOfException();
        lotto.gameStart(noe);
    }
}
