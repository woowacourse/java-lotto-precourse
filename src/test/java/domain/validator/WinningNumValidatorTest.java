package domain.validator;

import domain.LottoNumGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class WinningNumValidatorTest {

    @Test
    public void testWinningNumIsNotValidIfWinningNumIsNull() throws AssertionError {
        String[] winningNum = {null, null};
        WinningNumValidator winningNumValidator = new WinningNumValidator(winningNum);

        boolean doesLottoNumValid = winningNumValidator.doesLottoNumIsNotNull();

        assertFalse(doesLottoNumValid);
    }

    @Test
    public void testWinningNumIsNotValidIfWinningNumExceedBound() throws AssertionError {
        int lowerBound = LottoNumGenerator.LOTTO_NUM_LOWER_BOUND;
        int upperBound = LottoNumGenerator.LOTTO_NUM_LOWER_BOUND;
        String[] winningNum = {String.valueOf(lowerBound - 1), String.valueOf(upperBound + 1)};
        WinningNumValidator winningNumValidator = new WinningNumValidator(winningNum);

        boolean doesLottoNumValid = winningNumValidator.doesLottoNumNotExceedBound();

        assertFalse(doesLottoNumValid);
    }
}