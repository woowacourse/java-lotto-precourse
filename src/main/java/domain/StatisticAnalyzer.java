package domain;


import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class StatisticAnalyzer {
    private static final int COUNT_SCALE = 1;
    private static final int MINIMUM_FRACTION_DIGIT = 1;

    private void initialize(HashMap<Rank, Integer> rankDistributionTable, Rank[] typeOfRanks) {
        for (Rank rank : typeOfRanks) {
            rankDistributionTable.put(rank, 0);
        }
    }

    public HashMap<Rank, Integer> makeRankDistributionTableOf(HashMap<Lotto, Rank> lotteryResults) {
        HashMap<Rank, Integer> rankCounts = new LinkedHashMap<Rank, Integer>();

        initialize(rankCounts, Rank.values());
        for (Rank rank : lotteryResults.values()) {
            rankCounts.put(rank, rankCounts.get(rank) + COUNT_SCALE);
        }
        return rankCounts;
    }

    public double calculateEarningRatesBy(HashMap<Rank, Integer> rankDistributionTable) {
        int totalPurchase = rankDistributionTable.values().stream().mapToInt(Integer::intValue).sum()
                * LottoManager.PRICE_PER_LOTTO;
        int totalEarning = 0;

        for (Rank rank : rankDistributionTable.keySet()) {
            totalEarning += rank.getWinningMoney() * rankDistributionTable.get(rank);
        }
        return (double) totalEarning / (double) totalPurchase;
    }

    public String getCouningMessageOf(HashMap<Rank, Integer> rankDistributionTable, Rank rank) {
        StringBuilder message = new StringBuilder();

        message.append(rank.getCountOfMatch()).append("개 일치");
        if (rank == Rank.SECOND) {
            message.append(", 보너스 볼 일치 ");
        }
        message.append(" (").append(rank.getWinningMoney()).append("원) - ");
        message.append(rankDistributionTable.get(rank)).append("개");
        return message.toString();
    }

    public void show(HashMap<Rank, Integer> rankDistributionTable) {
        System.out.println("당첨 통계\n------");
        for (Rank rank : rankDistributionTable.keySet()) {
            System.out.println(getCouningMessageOf(rankDistributionTable, rank));
        }
    }

    public void show(double earningRates) {
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();

        percentFormatter.setMinimumFractionDigits(MINIMUM_FRACTION_DIGIT);
        System.out.println("총 수익률은 " + percentFormatter.format(earningRates) + "입니다");
    }

    public void showStatisticsOf(HashMap<Lotto, Rank> lotteryResults) {
        HashMap<Rank, Integer> rankDistributionTable = makeRankDistributionTableOf(lotteryResults);
        double earningRate = calculateEarningRatesBy(rankDistributionTable);

        show(rankDistributionTable);
        show(earningRate);
    }
}