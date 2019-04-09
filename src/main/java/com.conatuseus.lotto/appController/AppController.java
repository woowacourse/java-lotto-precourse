package com.conatuseus.lotto.appController;

import com.conatuseus.lotto.appView.AppView;
import com.conatuseus.lotto.model.Lotto;
import com.conatuseus.lotto.model.Rank;
import com.conatuseus.lotto.model.User;
import com.conatuseus.lotto.model.WinningLotto;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AppController {
    public static final int LOTTO_LENGTH = 6;
    public static final int MAX_LOTTO_VALUE = 45;
    public static final int MIN_LOTTO_VALUE = 1;
    private static final int MIN_VALUE_RANK_INDEX = 4;
    private static final int MAX_VALUE_RANK_INDEX = 0;

    private User user;
    private WinningLotto winningLotto;
    private Map<Rank, Integer> countOfRankResult;

    public AppController() {
        this.user = new User();
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

    public WinningLotto getWinningLotto() {
        return this.winningLotto;
    }

    private void setCountOfRankResult(Map<Rank, Integer> newMap) {
        this.countOfRankResult = newMap;
    }

    public Map<Rank, Integer> getCountOfRankResult() {
        return countOfRankResult;
    }

    public void run() throws IOException {
        AppView.outputLine(">> Lotto 게임을 시작합니다.");
        user.setBuyMoney(AppView.inputMoney());
        user.makeLottoList();
        AppView.printLottoList(user.getLottoList());
        this.makeWinningLotto();

        this.countingRank();
        this.printResult();
        AppView.outputLine("<< Lotto 게임을 종료합니다.");
    }

    private void makeWinningLotto() throws IOException {
        Lotto lotto = new Lotto(AppView.inputWinningLotto());
        int bonusNumber;
        do {
            bonusNumber = AppView.inputWinningBonusNumber();
        }
        while (bonusNumber == -1 || lotto.isContain(bonusNumber));
        this.setWinningLotto(new WinningLotto(lotto, bonusNumber));
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

    private void printResult() {
        long rateOfReturn = 0L;
        AppView.printResultOfLotto();
        for (int i = MIN_VALUE_RANK_INDEX; i >= MAX_VALUE_RANK_INDEX; i--) {
            Rank rank = Rank.values()[i];
            AppView.outputLine(rank.toString() + this.getCountOfRankResult().get(rank) + "개");
            rateOfReturn += (long) rank.getWinningMoney() * this.getCountOfRankResult().get(rank);
        }
        AppView.outputLine(String.format("%.3f", (double) rateOfReturn / user.getBuyMoney()));
    }
}
