/*
 * Game Class
 *
 * @version 2
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

/**
 * 전체 Lotto 게임을 관리하는 객체
 */
public class Game {
    private UserInterface ui;
    private List<Lotto> lottoList;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

    public Game(UserInterface ui) {
        this.ui = ui;
    }

    public void run() {
        int purchasePrice = purchasePrice();
        lottoList = createLottoList(purchasePrice / Lotto.UNIT_PRICE);
        printBoughtLottoList(lottoList);
        winningLotto = createWinLotto();
        lottoResult = createLottoResult(winningLotto, lottoList);
        printLottoStatistic(lottoResult);
    }

    private int purchasePrice(){
        return ui.inputPurchasePrice();
    }

    private List<Lotto> createLottoList(int quantity) {
        List<Lotto> lotList = new ArrayList<>();
        LottoFactory lotFactory = new LottoFactory();

        for (int th = 0; th < quantity; th++) {
            lotList.add(lotFactory.create());
        }
        return lotList;
    }

    private void printBoughtLottoList(List<Lotto> lotList){
        ui.printBoughtLottoList(lotList);
    }

    private WinningLotto createWinLotto() {
        Lotto preWinLot = new Lotto(ui.inputWinningLottoNums());
        int bonusNum = ui.inputBonusNum(preWinLot);

        return new WinningLotto(preWinLot, bonusNum);
    }

    private LottoResult createLottoResult(WinningLotto winningLot, List<Lotto> lotList) {
        LottoResult lotResult = new LottoResult();
        for (Lotto lot : lotList) {
            lotResult.put(winningLot.match(lot));
        }
        return lotResult;
    }

    private void printLottoStatistic(LottoResult lotResult){
        ui.printLottoStatistic(lotResult);
    }
}
