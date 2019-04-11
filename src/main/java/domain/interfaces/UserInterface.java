/*
 * UserInterface Interface
 *
 * @version 2
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

/**
 * 사용자와 interaction 하는 인터페이스
 */
public interface UserInterface {

    int inputPurchasePrice();

    boolean isInputPurchasePriceValid(String purchasePrice);

    List<Integer> inputWinningLottoNums();

    boolean isInputWinLottoNumsValid(String winNums);

    int inputBonusNum(Lotto preWinningLot);

    boolean isInputBonusNumValid(Lotto winLotto, String bonusNum);

    void printBoughtLottoList(List<Lotto> lotList);

    void printLottoNums(Lotto lot);

    void printLottoStatistic(LottoResult lotResult);

    void printRankResult(Rank rank, int count);
}
