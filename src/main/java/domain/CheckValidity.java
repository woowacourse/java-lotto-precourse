package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    boolean checkDoubleBonus(List<Integer> numArr, int number) {
        return numArr.contains(number);
    }

    boolean checkMinimumPurchaseAmount(int purchaseAmount) {
        return (purchaseAmount >= MIN_PURCHASE_AMOUNT);
    }

    boolean checkLottoNumberLength(String[] lottStr) {
        return (lottStr.length == LENGTH_LOTTO);
    }

    boolean checkDoubleNumbers(String[] lottoStr) {
        Set<String> lottoSet = new HashSet<>(Arrays.asList(lottoStr));

        return (lottoSet.size() == LENGTH_LOTTO);
    }
}
