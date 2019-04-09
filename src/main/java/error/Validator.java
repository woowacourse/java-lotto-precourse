package error;

import domain.Lotto;
import error.customExceptions.InvalidLottoException;
import error.customExceptions.MinimumPurchasePriceException;
import error.customExceptions.NotIntegerException;
import error.customExceptions.UndefinedException;

import java.util.Arrays;

public class Validator {
    private static final int MIN_PURCHASE_PRICE = 1000;

    public void checkAccuracyOfPurchasePrice(String input) {
        if (!isInteger(input)) {
            throw new NotIntegerException();
        }
        if (Integer.parseInt(input) < MIN_PURCHASE_PRICE) {
            throw new MinimumPurchasePriceException(MIN_PURCHASE_PRICE);
        }
    }

    public void checkAccuracyOfWinningNumbers(String[] inputs) {
        if (hasUndefined(inputs)) {
            throw new UndefinedException();
        }
        if (!isInteger(inputs)) {
            throw new NotIntegerException();
        }
        if (!areValidNumbersForLotto(inputs)) {
            throw new InvalidLottoException();
        }
    }

    public void checkAccuracyOfBonusNo(String input) {
        if (!isInteger(input)) {
            throw new NotIntegerException();
        }

    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isInteger(String[] inputs) {
        int lengthOfFiltered = Arrays.stream(inputs).filter(i->isInteger(i)).toArray().length;
        return (lengthOfFiltered == inputs.length);
    }

    private boolean hasUndefined(String[] inputs) {
        int lengthOfFiltered = Arrays.stream(inputs).filter(i->!(i.equals(""))).toArray().length;
        return (lengthOfFiltered != inputs.length);
    }

    private boolean areValidNumbersForLotto(String[] inputs) {
        return (inputs.length == Lotto.SIZE_OF_LOTTO)
                && (!haveDuplicate(inputs))
                && (isCorrectRange(inputs));
    }

    private boolean haveDuplicate(String[] inputs) {
        int lengthOfFiltered = Arrays.stream(inputs).distinct().toArray().length;
        return (lengthOfFiltered != inputs.length);
    }

    private boolean isCorrectRange(String[] inputs) {
        int lengthOfFiltered = Arrays.stream(inputs).mapToInt(Integer::parseInt)
                .filter(i->(i >= Lotto.FIRST_NUMBER) && (i <= Lotto.LAST_NUMBER))
                .toArray().length;
        return (lengthOfFiltered == inputs.length);
    }
}
