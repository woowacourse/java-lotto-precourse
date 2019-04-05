import domain.Rank;
import domain.WinningStatistics;
import org.junit.Assert;
import org.junit.Test;

public class WinningStatisticsTest {
    private static final int UNIT_PRICE_PER_LOTTO = 1000;

    @Test
    public void testStatistics() {
        WinningStatistics stat = new WinningStatistics();
        Rank[] wins = new Rank[]{Rank.FIFTH, Rank.MISS, Rank.MISS, Rank.MISS, Rank.MISS};
        for (Rank r : wins) {
            stat.put(r);
        }
        Assert.assertEquals(0, stat.getCountOfWinning(Rank.FIRST));
        Assert.assertEquals(1, stat.getCountOfWinning(Rank.FIFTH));
        Assert.assertEquals(1f, stat.calculateEarningRate(UNIT_PRICE_PER_LOTTO), 0.0001);
    }

    @Test
    public void testIntOverflow() {
        WinningStatistics stat = new WinningStatistics();
        for (int i = 0; i < 10; i++) {
            stat.put(Rank.FIRST);
        }
        Assert.assertEquals(2_000_000f, stat.calculateEarningRate(UNIT_PRICE_PER_LOTTO), 0.0001);
    }
}
