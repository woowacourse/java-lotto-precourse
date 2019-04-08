package com.conatuseus.lotto.appController;

import com.conatuseus.lotto.appView.AppView;
import com.conatuseus.lotto.model.User;
import com.conatuseus.lotto.model.WinningLotto;

import java.io.IOException;

public class AppController {
    private User user;
    private WinningLotto winningLotto;

    public AppController() {
        this.user = new User();
    }

    public void run() throws IOException {
        AppView.outputLine(">> Lotto 게임을 시작합니다.");
        user.setMoney(AppView.inputMoney());
        user.makeLottoList();
        AppView.printLottoList(user.getLottoList());

        AppView.outputLine("<< Lotto 게임을 종료합니다.");
    }


}
