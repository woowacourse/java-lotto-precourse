/*
 * ValidInterfaceImpl Class
 *
 * @version 2
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.impl;

import domain.interfaces.ValidInterface;
import domain.objects.Lotto;
import domain.objects.WinningLotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 사용자 입력을 검증하는 interface 의 구현체
 */
public class ValidInterfaceImpl implements ValidInterface {

    //입력된 구매가격 검증 시퀸스, 관련 모든 검사를 수행.
    @Override
    public void validPurchaseSequence(String purchasePrice) {
        validConvertToIntType(purchasePrice);
        validPurchasePriceDivisibleByUnitPrice(Integer.parseInt(purchasePrice));
        validPurchasePrice(Integer.parseInt(purchasePrice));
    }

    //입력된 당첨번호 검증 시퀸스, 관련 모든 검사를 수행.
    @Override
    public void validWinningLottoNumsSequence(String winLotNums) {
        String[] eachWinLotNums = winLotNums.split(",");

        validWinLottoNumsInt(eachWinLotNums);
        validWinLottoNumsCount(eachWinLotNums);
        validWinLottoNumsRange(eachWinLotNums);
        validWinLottoDuplicate(eachWinLotNums);
    }

    //입력된 보너스번호 검증 시퀸스, 관련 모든 검사를 수행.
    @Override
    public void validBonusNumSequence(Lotto preWinLotto, String bonusNum) {
        validConvertToIntType(bonusNum);
        validWinLottoNumRange(bonusNum);
        validBonusNumDuplicateWithWinLotto(preWinLotto, Integer.parseInt(bonusNum));
    }

    @Override
    public void validConvertToIntType(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 형태로 입력해주세요.");
        }
    }

    @Override
    public void validPurchasePriceDivisibleByUnitPrice(int purchasePrice) {
        if (purchasePrice % Lotto.UNIT_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    @Override
    public void validPurchasePrice(int purchasePrice) {
        if (MIN_PURCHASE_MONEY > purchasePrice || purchasePrice > MAX_PURCHASE_MONEY) {
            throw new IllegalArgumentException(" 1,000원 ~ 100,000원 사이로 입력해주세요.");
        }
    }

    @Override
    public void validWinLottoNumsInt(String[] winLottoNums) {
        for (String nums : winLottoNums) {
            validConvertToIntType(nums);
        }
    }

    @Override
    public void validWinLottoNumsCount(String[] winLottoNums) {
        if (winLottoNums.length != WinningLotto.WIN_NUMS_COUNT) {
            throw new IllegalArgumentException("6개의 번호를 입력해 주세요.");
        }
    }

    @Override
    public void validWinLottoNumsRange(String[] winLottoNums) {
        for (String num : winLottoNums) {
            validWinLottoNumRange(num);
        }
    }

    @Override
    public void validWinLottoNumRange(String lottoNum) {
        if ((Integer.parseInt(lottoNum) < Lotto.MIN_LOTTO_NUM)
                || (Integer.parseInt(lottoNum) > Lotto.MAX_LOTTO_NUM)) {
            throw new IllegalArgumentException("1~45 사이의 번호를 입력해주세요.");
        }
    }

    @Override
    public void validWinLottoDuplicate(String[] winLottoNums) {
        Set<String> winLottoSet = new HashSet<>(Arrays.asList(winLottoNums));
        if (winLottoSet.size() != WinningLotto.WIN_NUMS_COUNT) {
            throw new IllegalArgumentException("중복되지않은 번호를 입력해주세요.");
        }
    }

    @Override
    public void validBonusNumDuplicateWithWinLotto(Lotto preWinLotto, int bonusNum) {
        if (preWinLotto.contains(bonusNum)) {
            throw new IllegalArgumentException("당첨번호와 중복 되었습니다.");
        }
    }
}
