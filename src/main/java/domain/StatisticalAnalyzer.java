package domain;


import java.util.HashMap;

public class StatisticalAnalyzer {
    public HashMap<Rank, Integer> makeRankCountsTableOf(HashMap<Lotto, Rank> lotteryResults) {
        return null;
    }

    public double calculateEarningRateBy(HashMap<Rank, Integer> rankCounts) {
        return 0;
    }

    public void show(HashMap<Rank, Integer> rankCounts) {

    }

    public void show(double earningRate) {

    }

    public void analyzeEarningsOf(HashMap<Lotto, Rank> lotteryResults) {
        HashMap<Rank, Integer> rankCounts = makeRankCountsTableOf(lotteryResults);
        double earningRate = calculateEarningRateBy(rankCounts);

        show(rankCounts);
        show(earningRate);
    }
}