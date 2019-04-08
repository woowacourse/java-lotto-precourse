package domain.validator;

import domain.LottoFactory;
import domain.LottoNumGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class WinningNumValidatorTest {

    @Test
    public void testWinningNumIsNotValidIfWinningNumLengthIsNotEqualToStandardValue() {
        String[] winningNum = new String[LottoFactory.LOTTO_NUM_LENGTH - 1];
        WinningNumValidator winningNumValidator = new WinningNumValidator(winningNum);

        boolean doesLottoNumValid = winningNumValidator.doesLottoNumLengthIsValid();

        assertFalse(doesLottoNumValid);
    }

    @Test
    public void testWinningNumIsNotValidIfWinningNumExceedBound() throws AssertionError {
        int lowerBound = LottoNumGenerator.LOTTO_NUM_LOWER_BOUND;
        int upperBound = LottoNumGenerator.LOTTO_NUM_LOWER_BOUND;
        String[] winningNum = {String.valueOf(lowerBound - 1), String.valueOf(upperBound + 1)};
        WinningNumValidator winningNumValidator = new WinningNumValidator(winningNum);

        boolean doesLottoNumValid = winningNumValidator.doesEachLottoNumIsValid();

        assertFalse(doesLottoNumValid);
    }
}