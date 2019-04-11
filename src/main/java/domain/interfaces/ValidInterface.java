/*
 * ValidInterface Interface
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

/**
 * 사용자 입력을 검증하는 인터페이스
 */
public interface ValidInterface {
    int MAX_PURCHASE_MONEY = 100_000;
    int MIN_PURCHASE_MONEY = 1_000;

    //입력된 구매가격 검증 시퀸스, 관련 모든 검사를 수행.
    void validPurchaseSequence(String purchasePrice);

    //입력된 당첨번호 검증 시퀸스, 관련 모든 검사를 수행.
    void validWinningLottoNumsSequence(String winLottoNums);

    //입력된 보너스번호 검증 시퀸스, 관련 모든 검사를 수행.
    void validBonusNumSequence(Lotto preWinLotto, String bonusNum);

    void validConvertToIntType(String num);

    void validPurchasePriceDivisibleByUnitPrice(int purchasePrice);

    void validPurchasePrice(int purchasePrice);

    void validWinLottoNumsInt(String[] winLottoNums);

    void validWinLottoNumsCount(String[] winLottoNums);

    void validWinLottoNumsRange(String[] winLottoNums);

    void validWinLottoNumRange(String winLottoNum);

    void validWinLottoDuplicate(String[] winLottoNums);

    void validBonusNumDuplicateWithWinLotto(Lotto preWinLotto, int bonusNum);

}
