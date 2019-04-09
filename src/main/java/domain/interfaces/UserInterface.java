/*
 * UserInterface Interface
 *
 * @version 1.1
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.interfaces;

public interface UserInterface {

    int inputPurchasePrice();

    boolean isInputPurchasePriceValid(String purchasePrice);

    int[] inputWinningLottoNumbers();

    boolean isInputWinLotNumsValid(String winNums);

}
