/*
 *  @(#)AppController.java       3.00    2019/04/10
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 *  conatuseus@gmail.com
 */

package com.conatuseus.lotto.appController;

import com.conatuseus.lotto.appView.AppView;
import com.conatuseus.lotto.model.Lotto;
import com.conatuseus.lotto.model.Rank;
import com.conatuseus.lotto.model.User;
import com.conatuseus.lotto.model.WinningLotto;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Lotto game 로직을 담당하는 클래스
 */
public class AppController {
    public static final int LOTTO_LENGTH = 6;
    public static final int MAX_LOTTO_VALUE = 45;
    public static final int MIN_LOTTO_VALUE = 1;
    public static final int LOTTO_COST = 1000;
    private static final int MIN_VALUE_RANK_INDEX = 4;
    private static final int MAX_VALUE_RANK_INDEX = 0;

    private User user;
    private WinningLotto winningLotto;
    private Map<Rank, Integer> countOfRankResult;

    public AppController() {
        this.user = new User();
        this.mapInit();
    }

    /* 당첨 금액 별 count할 Map 초기화  */
    private void mapInit() {
        this.setCountOfRankResult(new HashMap<>());
        this.getCountOfRankResult().put(Rank.FIRST, 0);
        this.getCountOfRankResult().put(Rank.SECOND, 0);
        this.getCountOfRankResult().put(Rank.THIRD, 0);
        this.getCountOfRankResult().put(Rank.FOURTH, 0);
        this.getCountOfRankResult().put(Rank.FIFTH, 0);
        this.getCountOfRankResult().put(Rank.MISS, 0);
    }

    private void setWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    private WinningLotto getWinningLotto() {
        return this.winningLotto;
    }

    private void setCountOfRankResult(Map<Rank, Integer> newMap) {
        this.countOfRankResult = newMap;
    }

    private Map<Rank, Integer> getCountOfRankResult() {
        return countOfRankResult;
    }

    /* 실행 로직 */
    public void run() throws IOException {
        AppView.outputLine(">> Lotto 게임을 시작합니다.");
        user.setMoney(AppView.inputMoney());                            // Money 입력받아서 저장
        user.makeLottoList();                                           // user의 로또 List 생성
        AppView.printLottoList(user.getLottoList());                    // 사용자의 로또 출력

        this.makeWinningLotto();                                        // 지난주 당첨 로또 생성

        this.countingRank();                                            // 당첨 별로 counting
        this.printResult();
        AppView.outputLine("<< Lotto 게임을 종료합니다.");
    }

    /* 지난주 당첨번호 입력받아 생성하는 메소드 */
    private void makeWinningLotto() throws IOException {
        List<Integer> scannedWinningLotto = AppView.inputWinningLotto();
        Lotto scannedLotto = new Lotto(scannedWinningLotto);

        int scannedBonusNumber;
        do {
            scannedBonusNumber = AppView.inputWinningBonusNumber();
        } while (scannedBonusNumber == AppView.FAIL_INPUT || scannedLotto.isContain(scannedBonusNumber));           // 잘못된 입력 또는 보너스번호가 일반 당처 번호에 중복되면 계속

        this.setWinningLotto(new WinningLotto(scannedLotto, scannedBonusNumber));
    }

    private void countingRank() {
        for (Lotto userLotto : this.user.getLottoList()) {              // 사용자의 모든 로또를 돌며
            this.addCountOfRank(userLotto);                             // 해당 Rank의 value에+1해서 저장
        }
    }

    private void addCountOfRank(Lotto userLotto) {
        Rank rank = this.getWinningLotto().match(userLotto);
        this.getCountOfRankResult().put(rank, this.getCountOfRankResult().get(rank) + 1);
    }

    public void printResult() {
        long sumOfPrizeMoney = 0L;
        AppView.printPrefixResultOfLotto();

        for (int i = MIN_VALUE_RANK_INDEX; i >= MAX_VALUE_RANK_INDEX; i--) {
            Rank rank = Rank.values()[i];
            AppView.outputLine(rank.toString() + this.getCountOfRankResult().get(rank) + "개");
            sumOfPrizeMoney += this.getThisRankMoney(rank);
        }

        if (user.getMoney() <= 0) {
            AppView.outputLine("로또를 구매하지 않았습니다.");
        } else {
            AppView.outputLine(String.format("%.3f", this.getReturnOfRate(sumOfPrizeMoney, user.getMoney())));
        }
    }

    /* Map에서 해당 Rank의 당첨금과 value(개수)의 곱을 계산하는 메소드 */
    public long getThisRankMoney(Rank rank){
        return (long) rank.getWinningMoney() * this.getCountOfRankResult().get(rank);
    }

    /* 수익률 계산하는 메소드 */
    public double getReturnOfRate(Long sumOfPrizeMoney, int userMoney) {
        return (double) sumOfPrizeMoney / userMoney;
    }
}
