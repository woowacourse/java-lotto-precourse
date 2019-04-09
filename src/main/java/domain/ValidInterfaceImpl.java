/*
 * ValidInterfaceImpl Class
 *
 * @version 1.1
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain;

import domain.interfaces.ValidInterface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidInterfaceImpl implements ValidInterface {

    @Override
    public void validPurchaseSequence(String purchasePrice) {
        try {
            validConvertToIntType(purchasePrice);
            validPurchasePriceDivisibleByUnitPrice(Integer.parseInt(purchasePrice));
            validPurchasePrice(Integer.parseInt(purchasePrice));
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    public void validConvertToIntType(String purchasePrice) {
        try {
            Integer.parseInt(purchasePrice);
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

    //승리자번호 검증 시퀸스
    //모든 검사를 수행.
    @Override
    public void validWinningLottoSequence(String winLottoNums) {
        String[] eachWinLottoNum = winLottoNums.split(",");
        try {
            validWinLottoNumsInt(eachWinLottoNum);
            validWinLottoNumsCount(eachWinLottoNum);
            validWinLottoNumsRange(eachWinLottoNum);
            validWinLottoDuplicate(eachWinLottoNum);
        } catch (IllegalArgumentException e) {
            throw e;
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
    public void validWinLottoNumRange(String winLottoNum) {
        if ((Integer.parseInt(winLottoNum) < Lotto.MIN_LOTTO_NUM)
                || (Integer.parseInt(winLottoNum) > Lotto.MAX_LOTTO_NUM)) {
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
}
