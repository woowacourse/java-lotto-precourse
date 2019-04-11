package domain;

import java.util.List;

import static domain.Constant.*;
/**
 * 해당 데이터들이 로또게임에 맞는 타당한 값인지 확인하는 역할을 하는 클래스
 */
public class Validator {

    public static boolean isValidPurchaseAmount(int purchaseAmount) {
        return ((purchaseAmount >= PRIZE_OF_LOTTO)
                && (purchaseAmount % PRIZE_OF_LOTTO == ZERO)) ?
                true : false;
    }

    public static boolean isValidWinningNumbers(List<Integer> winningNumbers) {
        return (isValidSize(winningNumbers) && isValidRangeLottoNumbers(winningNumbers)
                && isNotOverlapLottoNumbers(winningNumbers))
                ? true : false;
    }

    private static boolean isValidSize(List<Integer> winningNumbers) {
        return winningNumbers.size() == LOTTO_SIZE ? true : false;
    }

    private static boolean isValidRangeLottoNumbers(List<Integer> winningNumbers) {
        int validCount = (int) winningNumbers.stream()
                .filter(n -> (n >= MIN_LOTTO_NUMBER && n <= MAX_LOTTO_NUMBER)).count();

        return validCount == LOTTO_SIZE ? true : false;
    }

    public static boolean isValidRangeLottoNumber(int lottoNumber) {
        return lottoNumber >= MIN_LOTTO_NUMBER && lottoNumber <= MAX_LOTTO_NUMBER ? true : false;
    }

    public static boolean isNotOverlapLottoNumbers(List<Integer> lottoNumbers) {
        boolean duplicate = lottoNumbers.stream()
                .distinct()
                .count() == lottoNumbers.size();

        return duplicate;
    }

    public static boolean isNotOverlapLottoNumber(List<Integer> lottoNumbers, int candidateLottoNumber) {
        return lottoNumbers.contains(candidateLottoNumber) ? false : true;
    }


}
