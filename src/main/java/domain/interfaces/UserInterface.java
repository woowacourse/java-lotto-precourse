/*
 * UserInterface Interface
 *
 * @version 1.4
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.interfaces;

import domain.objects.Lotto;

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
}
