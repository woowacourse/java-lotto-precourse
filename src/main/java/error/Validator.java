package error;

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
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean hasUndefined(String[] inputs) {
        int lengthOfFiltered = Arrays.stream(inputs).filter(i->!(i.equals(""))).toArray().length;
        return (lengthOfFiltered != inputs.length);
    }
}
