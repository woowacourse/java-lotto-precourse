package domain.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class PurchaseAmountValidatorTest {

    @Test
    public void testPurchaseAmountIsNotValidIfChangeExist() throws AssertionError {
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator("1111");

        boolean doesPurchaseAmountValid = purchaseAmountValidator.doesChangeNotExist();

        assertFalse(doesPurchaseAmountValid);
    }
}