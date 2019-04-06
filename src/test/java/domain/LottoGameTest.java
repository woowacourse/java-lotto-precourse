package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LottoGameTest {
    private LottoGame lottoGame;

    @Before
    public void setUp() throws Exception {
        lottoGame = new LottoGame();
    }
    @Test
    public void userInputVerify() {
        boolean result = lottoGame.inputPriceVerify(2000);
        Assert.assertEquals(true, result);
    }
    @Test
    public void userInputVerifyZero() {
        boolean result = lottoGame.inputPriceVerify(0);
        Assert.assertEquals(false, result);
    }
    @Test
    public void userInputVerifyNegative() {
        boolean result = lottoGame.inputPriceVerify(-1000);
        Assert.assertEquals(false, result);
    }
    @Test
    public void userInputVerifyNotThousandNumber() {
        boolean result = lottoGame.inputPriceVerify(1234);
        Assert.assertEquals(false, result);
    }

    @Test
    public void userInputSplit() {
        String[] result = lottoGame.userInputSplit("1,2,3");
        Assert.assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    public void userInputSplitBlank() {
        String[] result = lottoGame.userInputSplit("");
        Assert.assertArrayEquals(new String[]{}, result);
    }

    @Test
    public void userInputSplitNull() {
        String[] result = lottoGame.userInputSplit(null);
        Assert.assertArrayEquals(new String[]{}, result);
    }
}