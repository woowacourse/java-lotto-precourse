/*
 * @LottoGame.java      1.02 2019/04/10
 *
 * Copyright(c)2019     HwiJin Hong.
 * All right reserved.
 *
 * [ 우아한 테크코스 3주차 미션 ]
 * 로또 게임 프로그램
 */

package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 로또게임이 진행되는 클래스
 *
 * @author 홍휘진
 * @version 1.02 2019년 4월 10일
 */
public class LottoGame {

    private static final String MONEY_MSG = "0원 이상의 정수로 구입금액을 입력해 주세요.";
    private static final String MONEY_ERROR = "반드시 0원 이상의 정수로 입력해주세요!(최대 : 400만원)";
    private static final String MATCH_RESULT = "당첨 통계\n--------";
    private static final String HYPHEN = "- ";
    private static final String COUNT = "개";
    private static final String YIELD = "총 수익률은 ";
    private static final String YIELD_RESULT = "입니다.";
    private static final int MONEY_MIN_BOUND = 0;
    private static final int MONEY_MAX_BOUND = 4000000;

    private MyLottoManager myLottoManager;
    private WinningLottoMaker winningLottoMaker;
    private Scanner scanner;
    private int money;

    public LottoGame() {
        scanner = new Scanner(System.in);
        myLottoManager = new MyLottoManager();
        winningLottoMaker = new WinningLottoMaker(scanner);
    }

    public void lottoGameStart() {
        moneyInput();
        myLottoManager.buyLotto(money);
        matchLottoNumbers(winningLottoMaker.makeWinningLotto());
    }

    private void moneyInput() {
        System.out.println(MONEY_MSG);
        while (notValidMoney(scanner.nextLine())) {
            System.out.println(MONEY_ERROR);
        }
    }

    private boolean notValidMoney(String moneyScan) {
        if (!Validator.isValidNumber(moneyScan)) {
            return true;
        }
        money = Integer.parseInt(moneyScan);
        return ((money < MONEY_MIN_BOUND) || (money > MONEY_MAX_BOUND));
    }

    public void matchLottoNumbers(WinningLotto winningLotto) {
        HashMap<Rank, Integer> rankList = myLottoManager.matchWithWinningLotto(winningLotto);
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);
        int totalPrice = Rank.MISS.getWinningMoney();
        System.out.println(MATCH_RESULT);
        for (Rank rank : ranks) {
            totalPrice += printMatchResult(rankList, rank);
        }
        printLottoResult(totalPrice);
    }

    private int printMatchResult(HashMap<Rank, Integer> rankList, Rank rank) {
        if (rank.equals(Rank.MISS)) {
            return Rank.MISS.getWinningMoney();
        }
        System.out.println(rank + HYPHEN + rankList.get(rank) + COUNT);
        return saveMatchResult(rankList.get(rank), rank);
    }

    private int saveMatchResult(Integer count, Rank rank) {
        return (count * rank.getWinningMoney());
    }

    private void printLottoResult(int totalPrice) {
        System.out.println(YIELD + String.format("%.3f", caculateYield(totalPrice)) + YIELD_RESULT);
    }

    private double caculateYield(int totalPrice) {
        return (double) (totalPrice) / money;
    }
}
