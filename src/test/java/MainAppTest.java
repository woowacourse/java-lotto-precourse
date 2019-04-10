import domain.MainApp;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class MainAppTest extends TestCase {
    @Test
    public void testIsValidMoneyToBuyLotto() throws Exception {
        int testMoney;
        boolean isValid;

        testMoney = 1000;
        isValid = MainApp.isValidMoneyToBuyLotto(testMoney);
        assertEquals(true, isValid);

        testMoney = 1200;
        isValid = MainApp.isValidMoneyToBuyLotto(testMoney);
        assertEquals(false, isValid);

        testMoney = -1000;
        isValid = MainApp.isValidMoneyToBuyLotto(testMoney);
        assertEquals(false, isValid);
    }

    @Test
    public void testGetIntegerFromUser() throws Exception {
        int testInteger, enteredInteger;
        String strTestInteger;

        testInteger = 4000;
        strTestInteger = Integer.toString(testInteger);
        InputStream in = new ByteArrayInputStream(strTestInteger.getBytes());
        System.setIn(in);
        enteredInteger = MainApp.getIntegerFromUser();
        assertEquals(testInteger, enteredInteger);
    }


}
