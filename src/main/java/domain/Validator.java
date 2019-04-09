package domain;

import java.util.List;

public class Validator {
    private static final int UNIT_OF_PURCHASE_AMOUNT = 1000;
    private static final int VALID_REMAINDER = 0;
    private static final int VALID_LOTTO_SIZE = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    public static boolean isValidPurchaseAmount(int purchaseAmount) {
        return ((purchaseAmount >= UNIT_OF_PURCHASE_AMOUNT)
                && (purchaseAmount % UNIT_OF_PURCHASE_AMOUNT == VALID_REMAINDER)) ?
                true : false;
    }

    public static boolean isValidWinningNumber(List<Integer> winningNumbers) {
        return (isValidSize(winningNumbers) && isValidRangeLottoNumber(winningNumbers)
                && isOverlapLottoNumber(winningNumbers))
                ? true : false;
    }

    private static boolean isValidSize(List<Integer> winningNumbers) {
        return winningNumbers.size() == VALID_LOTTO_SIZE ? true : false;
    }

    private static boolean isValidRangeLottoNumber(List<Integer> winningNumbers) {
        int validCount = (int) winningNumbers.stream()
                .filter(n -> (n >= MIN_LOTTO_NUMBER && n <= MAX_LOTTO_NUMBER)).count();

        return validCount == VALID_LOTTO_SIZE ? true : false;
    }

    public static boolean isOverlapLottoNumber(List<Integer> lottoNumbers) {
        boolean duplicate = lottoNumbers.stream()
                .distinct()
                .count() != lottoNumbers.size();

        return duplicate;
    }


}
