package lotto.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WinPriceTest {
    private static final int FIRST_COUNT = 1;
    private static final int SECOND_COUNT = 3;
    private static final int THIRD_COUNT = 4;
    private static final int FOURTH_COUNT = 10;
    private static final int FIFTH_COUNT = 15;

    private WinPrice winPrice;

    @Before
    public void setup() {
        winPrice = new WinPrice();

        for (int i = 0; i < FIRST_COUNT; i++)
            winPrice.addWinCount(Rank.FIRST);

        for (int i = 0; i < SECOND_COUNT; i++)
            winPrice.addWinCount(Rank.SECOND);

        for (int i = 0; i < THIRD_COUNT; i++)
            winPrice.addWinCount(Rank.THIRD);

        for (int i = 0; i < FOURTH_COUNT; i++)
            winPrice.addWinCount(Rank.FOURTH);

        for (int i = 0; i < FIFTH_COUNT; i++)
            winPrice.addWinCount(Rank.FIFTH);

    }

    @Test
    public void WinCount_테스트(){
        Assert.assertTrue(FIFTH_COUNT==winPrice.getWinCount(Rank.FIFTH));
        Assert.assertTrue(SECOND_COUNT==winPrice.getWinCount(Rank.SECOND));
    }

}
