package domain.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoNumValidatorTest {

    @Test
    public void testLottoNumIsNotValidIfLottoNumIsNull() throws AssertionError {
        String[] lottoNum = {null, null};
        LottoNumValidator lottoNumValidator = new LottoNumValidator(lottoNum);

        boolean doesLottoNumValid = lottoNumValidator.doesLottoNumIsNotNull();

        assertFalse(doesLottoNumValid);
    }
}