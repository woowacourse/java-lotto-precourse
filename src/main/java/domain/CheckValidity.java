package domain;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 입력받은 값이 유효한지 확인하는 행위를 하는 클래스
 *
 * @author 송윤재
 * @version 1.0
 */
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

    /**
     * Set 자료구조를 통해 중복되 값이 있으면 LENGTH_LOTTO와 다른 것을 이용했다.
     *
     * @param lottoStr 중복을 확인하기 위한 lotto번호
     * @return True: 중복이 없다. False: 중복된 값이 존재
     */
    boolean checkDoubleNumbers(String[] lottoStr) {
        Set<String> lottoSet = new HashSet<>(Arrays.asList(lottoStr));

        return (lottoSet.size() == LENGTH_LOTTO);
    }
}
