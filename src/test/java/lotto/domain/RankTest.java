package lotto.domain;

import org.junit.Assert;
import org.junit.Test;

public class RankTest {

    @Test
    public void valueOf_테스트() {
        Assert.assertEquals(Rank.FIRST, Rank.valueOf(6,false));
        Assert.assertEquals(Rank.SECOND, Rank.valueOf(5,true));
        Assert.assertEquals(Rank.THIRD, Rank.valueOf(5,false));
        Assert.assertEquals(Rank.FOURTH, Rank.valueOf(4,false));
        Assert.assertEquals(Rank.FOURTH, Rank.valueOf(4,true));
        Assert.assertEquals(Rank.FIFTH, Rank.valueOf(3,false));
        Assert.assertEquals(Rank.FIFTH, Rank.valueOf(3,true));
    }
}
