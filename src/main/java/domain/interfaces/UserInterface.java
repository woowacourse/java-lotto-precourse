/*
 * UserInterface Interface
 *
 * @version 1.2
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.interfaces;

import domain.Lotto;
import domain.WinningLotto;

public interface UserInterface {

    int inputPurchasePrice();

    boolean isInputPurchasePriceValid(String purchasePrice);

    int[] inputWinningLottoNumbers();

    boolean isInputWinLotNumsValid(String winNums);

    int inputBonusNum(Lotto preWinLotto);

    boolean isInputBonusNumValid(Lotto winLotto, String bonusNum);
}
