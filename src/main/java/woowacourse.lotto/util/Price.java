/*
 * Price.java
 * version 1.0
 * 2019.04.11
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package woowacourse.lotto.util;

import java.util.Scanner;

/**
 * 지불한 금액을 나타내는 객체
 */
class Price {
    private static final int NEGATIVE_SYMBOLIC_NUMBER = -1;
    private static final String GET_PRICE_GUIDE =
            "구입금액을 입력해 주세요.";
    private static final String GET_PRICE_WARNING =
            "구입금액의 값을 입력해 주세요.";
    private static final String NOT_PAID_WARNING =
            "구입하지 않으셨습니다.";
    private static final String PRICE_DIVISIBLE_WARNING =
            "1000원 단위로 입력해 주세요.";
    private static final String LOTTO_COUNT_GUIDE =
            "\n%d개를 구매했습니다.\n";

    private int totalPrice;

    void saveTotalPrice(Scanner scan) {
        System.out.println(GET_PRICE_GUIDE);
        totalPrice = NEGATIVE_SYMBOLIC_NUMBER;
        while (totalPrice == NEGATIVE_SYMBOLIC_NUMBER) {
            totalPrice = getValidPriceOrError(scan);
        }
        System.out.format(LOTTO_COUNT_GUIDE,
                totalPrice / LottoShop.PRICE_PER_LOTTO);
    }

    int getNumLotto() {
        return totalPrice / LottoShop.PRICE_PER_LOTTO;
    }

    private int getValidPriceOrError(Scanner scan) {
        int inputPrice;
        try {
            inputPrice = Integer.valueOf(scan.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(GET_PRICE_WARNING);
            return NEGATIVE_SYMBOLIC_NUMBER;
        }
        return checkPrice(inputPrice) ? inputPrice
                : NEGATIVE_SYMBOLIC_NUMBER;
    }

    private boolean checkPrice(int inputPrice) {
        if (inputPrice <= 0) {
            System.out.println(NOT_PAID_WARNING);
            return false;
        }
        if (inputPrice % LottoShop.PRICE_PER_LOTTO != 0) {
            System.out.println(PRICE_DIVISIBLE_WARNING);
            return false;
        }
        return true;
    }
}
