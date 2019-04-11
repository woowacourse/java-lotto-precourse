/*
 * ValidInterface Interface
 *
 * @version 1.2
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.interfaces;

import domain.objects.Lotto;

public interface ValidInterface {
    int MAX_PURCHASE_MONEY = 100_000;
    int MIN_PURCHASE_MONEY = 1_000;

    void validPurchaseSequence(String purchasePrice);

    void validConvertToIntType(String num);

    void validPurchasePriceDivisibleByUnitPrice(int purchasePrice);

    void validPurchasePrice(int purchasePrice);

    void validWinningLottoSequence(String winLottoNums);

    void validWinLottoNumsInt(String[] winLottoNums);

    void validWinLottoNumsCount(String[] winLottoNums);

    void validWinLottoNumsRange(String[] winLottoNums);

    void validWinLottoNumRange(String winLottoNum);

    void validWinLottoDuplicate(String[] winLottoNums);

    void validBonusNumSequence(Lotto preWinLotto, String bonusNum);

    void validBonusNumDuplicateWithWinLotto(Lotto preWinLotto, int bonusNum);

}
