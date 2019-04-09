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

    private User user;
    private WinningLotto winningLotto;
    private HashMap<Rank,Integer> countOfRankResult;

    public AppController() {
        this.user = new User();
        this.countOfRankResult = new HashMap<>();
        this.countOfRankResult.put(Rank.FIRST, 0);
        this.countOfRankResult.put(Rank.SECOND, 0);
        this.countOfRankResult.put(Rank.THIRD, 0);
        this.countOfRankResult.put(Rank.FOURTH, 0);
        this.countOfRankResult.put(Rank.FIFTH, 0);
    }

    public void setWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public WinningLotto getWinningLotto() {
        return this.winningLotto;
    }

    public Map<Rank, Integer> getCountOfRankResult() {
        return countOfRankResult;
    }

    public void run() throws IOException {
        AppView.outputLine(">> Lotto 게임을 시작합니다.");
        user.setMoney(AppView.inputMoney());
        user.makeLottoList();
        AppView.printLottoList(user.getLottoList());
        this.makeWinningLotto();

        this.countingRank();
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
        Rank rank;
        for (Lotto userLotto : this.user.getLottoList()) {
            this.addCountOfRank(userLotto);
        }
    }

    private void addCountOfRank(Lotto userLotto) {
        Rank rank = this.getWinningLotto().match(userLotto);
        if (this.getCountOfRankResult().containsKey(rank)) {
            this.getCountOfRankResult().put(rank, this.getCountOfRankResult().get(rank) + 1);
        }
    }

}
