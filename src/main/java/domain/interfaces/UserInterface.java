/*
 * UserInterface Interface
 *
 * @version 1.3
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.interfaces;

import domain.Lotto;
import domain.WinningLotto;

import java.util.List;

public interface UserInterface {

    int inputPurchasePrice();

    boolean isInputPurchasePriceValid(String purchasePrice);

    int[] inputWinningLottoNumbers();

    boolean isInputWinLotNumsValid(String winNums);

    int inputBonusNum(Lotto preWinLotto);

    boolean isInputBonusNumValid(Lotto winLotto, String bonusNum);

    void printBoughtLottos(List<Lotto> lottoList);

    void printLottoNums(Lotto lotto);
}
