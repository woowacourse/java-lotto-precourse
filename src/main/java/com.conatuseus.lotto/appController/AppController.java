package com.conatuseus.lotto.appController;

import com.conatuseus.lotto.appView.AppView;
import com.conatuseus.lotto.model.Lotto;
import com.conatuseus.lotto.model.User;
import com.conatuseus.lotto.model.WinningLotto;

import java.io.IOException;

public class AppController {
    public static final int LOTTO_LENGTH = 6;
    public static final int MAX_LOTTO_VALUE = 45;
    public static final int MIN_LOTTO_VALUE = 1;

    private User user;
    private WinningLotto winningLotto;

    public AppController() {
        this.user = new User();
    }

    public void setWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void run() throws IOException {
        AppView.outputLine(">> Lotto 게임을 시작합니다.");
        user.setMoney(AppView.inputMoney());
        user.makeLottoList();
        AppView.printLottoList(user.getLottoList());
        this.makeWinningLotto();

        AppView.outputLine("<< Lotto 게임을 종료합니다.");
    }

    public void makeWinningLotto() throws IOException {
        Lotto lotto = new Lotto(AppView.inputWinningLotto());
        int bonusNumber;
        do {
            bonusNumber = AppView.inputWinningBonusNumber();
        }
        while (bonusNumber==-1 || lotto.isContain(bonusNumber));
        this.setWinningLotto(new WinningLotto(lotto, bonusNumber));
    }


}
