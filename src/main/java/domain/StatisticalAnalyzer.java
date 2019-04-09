package domain;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class StatisticalAnalyzer {
    private static final int COUNT_SCALE = 1;

    public void initialize(HashMap<Rank, Integer> rankCounts, Rank[] typeOfranks) {
        for (Rank rank: typeOfranks) {
            rankCounts.put(rank, 0);
        }
    }

    public HashMap<Rank, Integer> makeRankCountsTableOf(HashMap<Lotto, Rank> lotteryResults) {
        HashMap<Rank, Integer> rankCounts = new LinkedHashMap<Rank, Integer>();

        initialize(rankCounts, Rank.values());
        for (Rank rank: lotteryResults.values()) {
            rankCounts.put(rank, rankCounts.get(rank) + COUNT_SCALE);
        }
        return rankCounts;
    }

    public double calculateEarningRateBy(HashMap<Rank, Integer> rankCounts) {
        int totalPurchase = rankCounts.values().stream().mapToInt(Integer::intValue).sum()
                * LottoManager.PRICE_PER_LOTTO;
        int totalEarning = 0;

        for (Rank rank: rankCounts.keySet()) {
            totalEarning += rank.getWinningMoney() * rankCounts.get(rank);
        }
        return (double) totalEarning / (double) totalPurchase;
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