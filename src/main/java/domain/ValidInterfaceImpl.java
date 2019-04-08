/*
 * ValidInterfaceImpl Class
 *
 * @version 1
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain;

import domain.interfaces.ValidInterface;

public class ValidInterfaceImpl implements ValidInterface {

    @Override
    public boolean validConvertToIntType(String inputNums) {
        try {
            Integer.parseInt(inputNums);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 형태로 입력해주세요.");
        }
        return true;
    }

    @Override
    public boolean validPurchasePriceDivisibleByUnitPrice(int purchaseAmount) {
        if (purchaseAmount % Lotto.UNIT_PRICE != 0)
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        return true;
    }

    @Override
    public boolean validPurchasePrice(int purchaseAmount) {
        if (MIN_PURCHASE_MONEY > purchaseAmount || purchaseAmount > MAX_PURCHASE_MONEY)
            throw new IllegalArgumentException(" 1000원 ~ 100,000원 사이로 입력해주세요.");
        return true;
    }

    @Override
    public boolean validPurcahseSequence(String purchasePrice) {
        try {
            validConvertToIntType(purchasePrice);
            validPurchasePriceDivisibleByUnitPrice(Integer.parseInt(purchasePrice));
            validPurchasePrice(Integer.parseInt(purchasePrice));
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return true;
    }

}
