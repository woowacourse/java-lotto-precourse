/*
 * Game Class
 *
 * @version 1
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

import java.util.ArrayList;
import java.util.List;

public class Game {
    private UserInterface ui;
    private List<Lotto> lottos;

    public Game(UserInterface ui) {
        this.ui = ui;
    }

    public void run() {
        int purchasePrice = ui.inputPurchasePrice();
        lottos = createLottos(purchasePrice / Lotto.UNIT_PRICE);
        ui.printBoughtLottos(lottos);

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
