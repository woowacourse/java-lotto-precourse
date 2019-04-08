package error;

import error.customExceptions.MinPurchasePriceException;
import error.customExceptions.NotIntegerException;

public class Validator {
    private static final int minPurchasePrice = 1000;

    public void checkAccuracyOfPurchasePrice(String input) {
        if (!isInteger(input)) {
            throw new NotIntegerException();
        }
        if (Integer.parseInt(input) < minPurchasePrice) {
            throw new MinPurchasePriceException(minPurchasePrice);
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
}
