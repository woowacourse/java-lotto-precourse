package domain;

import java.util.ArrayList;
import java.util.List;

class CheckValidity {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int LENGTH_LOTTO = 6;

    boolean checkIntegerFormat(String numberStr) {
        try {
            Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    boolean checkLottoNumberScope(int number) {
        return !((number < MIN_NUMBER) || (MAX_NUMBER < number));
    }

    boolean checkDouble(List<Integer> numArr, int number) {
        return numArr.contains(number);
    }

    boolean checkMinimumPurchaseAmount(int purchaseAmount){
        return (purchaseAmount >= MIN_PURCHASE_AMOUNT);
    }

    boolean checkLottoNumberLength(String[] lottStr){
        return (lottStr.length == LENGTH_LOTTO);
    }
}
