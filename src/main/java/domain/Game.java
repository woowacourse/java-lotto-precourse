/*
 * Game Class
 *
 * @version 1.2
 *
 * @date 2019-04-11
 *
 * Copyright (c) 2019. Jihun oh
 * All rights reserved.
 */
package domain;

import domain.interfaces.UserInterface;
import domain.objects.Lotto;
import domain.objects.LottoFactory;
import domain.objects.LottoResult;
import domain.objects.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private UserInterface ui;
    private List<Lotto> lottos;
    private WinningLotto winLotto;
    private LottoResult lottoResult;

    public Game(UserInterface ui) {
        this.ui = ui;
    }

    public void run() {
        int purchasePrice = ui.inputPurchasePrice();
        lottos = createLottos(purchasePrice / Lotto.UNIT_PRICE);
        ui.printBoughtLottos(lottos);
        winLotto = createWinLotto();
        lottoResult = createLottoResult(winLotto, lottos);
        ui.printLottoStatistic(lottoResult);
    }

    private WinningLotto createWinLotto() {
        Lotto preWinLotto = new Lotto(ui.inputWinningLottoNumbers());
        int bonusNum = ui.inputBonusNum(preWinLotto);

        return new WinningLotto(preWinLotto, bonusNum);
    }

    private LottoResult createLottoResult(WinningLotto winLotto, List<Lotto> lottos) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            lottoResult.put(winLotto.match(lotto));
        }
        return lottoResult;
    }

    private List<Lotto> createLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        LottoFactory lottoFactory = new LottoFactory();

        for (int th = 0; th < quantity; th++) {
            lottos.add(lottoFactory.createLotto());
        }
        return lottos;
    }

}
