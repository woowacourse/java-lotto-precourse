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

    public void run() throws IOException {
        AppView.outputLine(">> Lotto 게임을 시작합니다.");
        user.setMoney(AppView.inputMoney());
        user.makeLottoList();
        AppView.printLottoList(user.getLottoList());

        this.makeWinningLotto();

        this.countingRank();
        this.printResult();
        AppView.outputLine("<< Lotto 게임을 종료합니다.");
    }

    private void makeWinningLotto() throws IOException {
        List<Integer> scannedWinningLotto = AppView.inputWinningLotto();
        Lotto scannedLotto = new Lotto(scannedWinningLotto);

        int scannedBonusNumber;
        do {
            scannedBonusNumber = AppView.inputWinningBonusNumber();
        } while (scannedBonusNumber == AppView.FAIL_INPUT || scannedLotto.isContain(scannedBonusNumber));

        this.setWinningLotto(new WinningLotto(scannedLotto, scannedBonusNumber));
    }

    private void countingRank() {
        for (Lotto userLotto : this.user.getLottoList()) {
            this.addCountOfRank(userLotto);
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
            sumOfPrizeMoney += (long) rank.getWinningMoney() * this.getCountOfRankResult().get(rank);
        }

        if (user.getMoney() <= 0) {
            AppView.outputLine("로또를 구매하지 않았습니다.");
        } else {
            AppView.outputLine(String.format("%.3f", this.getReturnOfRate(sumOfPrizeMoney, user.getMoney())));
        }
    }

    public double getReturnOfRate(Long sumOfPrizeMoney, int userMoney) {
        return (double) sumOfPrizeMoney / userMoney;
    }
}
