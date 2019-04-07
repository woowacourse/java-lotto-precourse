package domain.validator;

import org.junit.Test;
import static org.junit.Assert.*;

public class LottoInputValidatorTest {

    @Test
    public void testInputIsNotValidIfInputHasCharacter() throws AssertionError {
        LottoInputValidator inputValidator = new LottoInputValidator("a");

        boolean doesInputValid = inputValidator.doesInputIsNumeric();

        assertFalse(doesInputValid);
    }
}