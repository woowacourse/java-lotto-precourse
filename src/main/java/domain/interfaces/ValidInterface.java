/*
 * ValidInterface Interface
 *
 * @version 1
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.interfaces;

public interface ValidInterface {
    int MAX_PURCHASE_MONEY = 100_000;
    int MIN_PURCHASE_MONEY = 1_000;

    boolean validPurchasePrice(int purchaseAmount);

    boolean validConvertToIntType(String inputPrice);

    boolean validPurchasePriceDivisibleByUnitPrice(int purchaseAmount);

    boolean validPurcahseSequence(String inputPrice);
}
