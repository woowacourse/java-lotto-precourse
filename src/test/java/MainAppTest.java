import domain.Lotto;
import domain.MainApp;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;


public class MainAppTest extends TestCase {
    static final int VALID_MONEY_TO_BUY_LOTTO = 1000;
    static final int INVALID_MONEY_TO_BUY_LOTTO_NOT_TIMES_OF_LOTTO_PRICE = 1200;
    static final int INVALID_MONEY_TO_BUY_LOTTO_ZERO = 0;
    static final int INVALID_MONEY_TO_BUY_LOTTO_NEGATIVE_NUMBER = -1000;
    @Test
    public void testIsValidMoneyToBuyLotto() throws Exception {
        int testMoney;
        boolean isValid;

        testMoney = VALID_MONEY_TO_BUY_LOTTO;
        isValid = MainApp.isValidMoneyToBuyLotto(testMoney);
        assertEquals(true, isValid);

        testMoney = INVALID_MONEY_TO_BUY_LOTTO_NEGATIVE_NUMBER;
        isValid = MainApp.isValidMoneyToBuyLotto(testMoney);
        assertEquals(false, isValid);

        testMoney = INVALID_MONEY_TO_BUY_LOTTO_NOT_TIMES_OF_LOTTO_PRICE;
        isValid = MainApp.isValidMoneyToBuyLotto(testMoney);
        assertEquals(false, isValid);

        testMoney = INVALID_MONEY_TO_BUY_LOTTO_ZERO;
        isValid = MainApp.isValidMoneyToBuyLotto(testMoney);
        assertEquals(false, isValid);
    }

    @Test
    public void testGetIntegerFromUser() throws Exception {
        int testInteger, enteredInteger;
        String strTestInteger;

        testInteger = VALID_MONEY_TO_BUY_LOTTO;
        strTestInteger = Integer.toString(testInteger);
        InputStream in = new ByteArrayInputStream(strTestInteger.getBytes());
        System.setIn(in);
        enteredInteger = MainApp.getIntegerFromUser();
        assertEquals(testInteger, enteredInteger);
    }

    @Test
    public void testGetMoneyToBuyLotto() throws Exception {
        int testMoney, enteredMoney;
        String strTestMoney;

        testMoney = VALID_MONEY_TO_BUY_LOTTO;
        strTestMoney = Integer.toString(testMoney);
        InputStream in = new ByteArrayInputStream(strTestMoney.getBytes());
        System.setIn(in);
        enteredMoney = MainApp.getMoneyToBuyLotto();
        assertEquals(testMoney, enteredMoney);
    }

    @Test
    public void testCreateLottosWorth() throws Exception {
        int testMoney = VALID_MONEY_TO_BUY_LOTTO;
        ArrayList<Lotto> lottos = MainApp.createLottosWorth(VALID_MONEY_TO_BUY_LOTTO);
        assertEquals(1, lottos.size());
    }

    @Test
    public void testPrintLotto() throws Exception {
        Lotto testLotto = new Lotto(Arrays.asList(new Integer[] {1, 15, 22, 33, 35, 42}));
        assertEquals("[1, 15, 22, 33, 35, 42]", testLotto.toString());
    }
}
