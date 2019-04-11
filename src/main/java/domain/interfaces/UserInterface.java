/*
 * UserInterface Interface
 *
 * @version 1.5
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.interfaces;

import domain.objects.Lotto;
import domain.objects.LottoResult;
import domain.objects.Rank;

import java.util.List;

public interface UserInterface {

    int inputPurchasePrice();

    boolean isInputPurchasePriceValid(String purchasePrice);

    List<Integer> inputWinningLottoNumbers();

    boolean isInputWinLotNumsValid(String winNums);

    int inputBonusNum(Lotto preWinLotto);

    boolean isInputBonusNumValid(Lotto winLotto, String bonusNum);

    void printBoughtLottos(List<Lotto> lottoList);

    void printLottoNums(Lotto lotto);

    void printLottoStatistic(LottoResult lottoResult);

    void printEachRankResult(Rank rank, int count);
}
