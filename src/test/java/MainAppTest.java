import domain.Lotto;
import domain.MainApp;
import domain.Rank;
import domain.WinningLotto;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainAppTest extends TestCase {
    static final int VALID_MONEY_TO_BUY_LOTTO = 1000;
    static final int INVALID_MONEY_TO_BUY_LOTTO_NOT_TIMES_OF_LOTTO_PRICE = 1200;
    static final int INVALID_MONEY_TO_BUY_LOTTO_ZERO = 0;
    static final int INVALID_MONEY_TO_BUY_LOTTO_NEGATIVE_NUMBER = -1000;

    static final Integer[] VALID_LOTTO_NUMBERS = new Integer[]{1, 15, 22, 33, 35, 42};
    static final Integer[] INVALID_LOTTO_NUMBERS_NOT_SIX = new Integer[]{1, 15, 22, 33, 35, 42, 44};
    static final Integer[] INVALID_LOTTO_NUMBERS_OUT_OF_BOUNDS = new Integer[]{-32, 15, 22, 33, 35, 4255};
    static final Integer[] INVALID_LOTTO_NUMBERS_DUPLICATION = new Integer[]{15, 15, 22, 33, 35, 42};

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
        enteredInteger = MainApp.getIntegerFromUser(MainApp.MESSAGE_WRONG_MONEY_TO_BUY_LOTTO);
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
        List<Lotto> lottos = MainApp.makeLottosWorth(VALID_MONEY_TO_BUY_LOTTO);
        assertEquals(1, lottos.size());
    }

    @Test
    public void testPrintLotto() throws Exception {
        Lotto testLotto = new Lotto(Arrays.asList(new Integer[]{1, 15, 22, 33, 35, 42}));
        assertEquals("[1, 15, 22, 33, 35, 42]", testLotto.toString());
    }

    @Test
    public void testIsValidLottoNumber() throws Exception {
        List<Integer> testWinningNumbers;
        boolean isValid;

        testWinningNumbers = new ArrayList<Integer>(Arrays.asList(VALID_LOTTO_NUMBERS));
        isValid = MainApp.areValidLottoNumbers(testWinningNumbers);
        assertEquals(true, isValid);

        testWinningNumbers = new ArrayList<Integer>(Arrays.asList(INVALID_LOTTO_NUMBERS_NOT_SIX));
        isValid = MainApp.areValidLottoNumbers(testWinningNumbers);
        assertEquals(false, isValid);

        testWinningNumbers = new ArrayList<Integer>(Arrays.asList(INVALID_LOTTO_NUMBERS_OUT_OF_BOUNDS));
        isValid = MainApp.areValidLottoNumbers(testWinningNumbers);
        assertEquals(false, isValid);

        testWinningNumbers = new ArrayList<Integer>(Arrays.asList(INVALID_LOTTO_NUMBERS_DUPLICATION));
        isValid = MainApp.areValidLottoNumbers(testWinningNumbers);
        assertEquals(false, isValid);
    }

    @Test
    public void testIsSet() throws Exception {
        List<Integer> testList;

        testList = new ArrayList<Integer>(Arrays.asList(VALID_LOTTO_NUMBERS));
        assertEquals(true, MainApp.isSet(testList));

        testList = new ArrayList<Integer>(Arrays.asList(INVALID_LOTTO_NUMBERS_DUPLICATION));
        assertEquals(false, MainApp.isSet(testList));
    }

    @Test
    public void testGetWinningNumbers() throws Exception {
        String strTestWinningNumbers;

        strTestWinningNumbers = "1,15,22,33,35,42";
        InputStream in = new ByteArrayInputStream(strTestWinningNumbers.getBytes());
        System.setIn(in);
        List<Integer> winningNumbers = MainApp.getWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);
        assertEquals("[1, 15, 22, 33, 35, 42]", winningLotto.toString());
    }

    @Test
    public void testRankLottos() throws Exception {
        List<Integer> testList;
        testList = new ArrayList<Integer>(Arrays.asList(VALID_LOTTO_NUMBERS));
        Lotto testLotto = new Lotto(testList);
        WinningLotto testWinningLotto = new WinningLotto(testLotto, 10);

        List<Lotto> testLottos = new ArrayList<Lotto>();
        testLottos.add(testLotto);

        List<Rank> ranks = MainApp.rankLottos(testWinningLotto, testLottos);

        assertEquals(1, ranks.size());
        assertEquals(Rank.FIRST, ranks.get(0));
    }

    @Test
    public void testCalculateRevenue() throws Exception {
        List<Integer> statisticsOfRanks = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 0, 0, 0, 0, 0}));
        int revenue = MainApp.calculateRevenue(statisticsOfRanks);
        assertEquals(Rank.FIRST.getWinningMoney(), revenue);
    }
}
