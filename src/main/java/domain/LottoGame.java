/*
 * @LottoGame.java		1.00 2019/04/10
 *
 * Copyright(c)2019		HwiJin Hong.
 * All right reserved.
 *
 * [ 우아한 테크코스 3주차 미션 ]
 * 로또 게임 프로그램
 */

package domain;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 로또게임이 진행되는 클래스
 *
 * @author 홍휘진
 * @version 1.00 2019년 4월 10일
 */
public class LottoGame {

    private static final String MONEY_MSG = "0원 이상의 정수로 구입금액을 입력해 주세요.";

    private static final String MONEY_ERROR = "반드시 0원 이상의 정수로 입력해주세요!";

    private static final String MATCH_RESULT = "당첨 통계\n--------";

    private static final String HYPHEN = "- ";

    private static final String COUNT = "개";

    private static final int MONEY_MIN_BOUND = 0;

    private static final int MONEY_MAX_BOUND = 4000000;

    private MyLottoManager myLottoManager;

    private WinningLottoMaker winningLottoMaker;

    private WinningLotto winningLotto;

    private Scanner scanner;

    private int totalPrice;

    private int money;

    public LottoGame() {
        scanner = new Scanner(System.in);
        myLottoManager = new MyLottoManager();
        winningLottoMaker = new WinningLottoMaker(scanner);
        totalPrice = Rank.MISS.getWinningMoney();
    }

    public static boolean isValidNumber(String numberScan) {
        try {
            Integer.parseInt(numberScan);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void lottogame() {
        moneyInput();
        myLottoManager.buyLotto(money);
        winningLotto = winningLottoMaker.makeWinninglotto();
        matchLottoNumbers();
    }

    private void moneyInput() {
        System.out.println(MONEY_MSG);
        while (notValidMoney(scanner.nextLine())) {
            System.out.println(MONEY_ERROR);
        }
    }

    private boolean notValidMoney(String moneyScan) {
        if (!isValidNumber(moneyScan)) {
            return true;
        }
        money = Integer.parseInt(moneyScan);
        if ((money < MONEY_MIN_BOUND) || (money > MONEY_MAX_BOUND)) {
            return true;
        }
        return false;
    }

    public void matchLottoNumbers() {
        HashMap<Rank, Integer> rankList = myLottoManager.matchWithWinningLotto(winningLotto);
        System.out.println(MATCH_RESULT);
        for (Rank rank : Rank.values()) {
            printMatchResult(rankList, rank);
        }
    }

    private void printMatchResult(HashMap<Rank, Integer> rankList, Rank rank) {
        if (rank.equals(Rank.MISS)) {
            return;
        }
        System.out.println(rank + HYPHEN + rankList.get(rank) + COUNT);
        saveMatchResult(rankList.get(rank), rank);
    }

    private void saveMatchResult(Integer count, Rank rank) {
        totalPrice += (count * rank.getWinningMoney());
    }
}
