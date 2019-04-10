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
}
