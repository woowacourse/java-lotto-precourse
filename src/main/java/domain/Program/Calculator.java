package domain.Program;

import domain.Elements.Rank;
import domain.Elements.Winningstatistics;

public class Calculator {
    public static double setEarningRate(Winningstatistics winningstatistics, long pay) {
        return setTotalEarningMoney(winningstatistics) / pay;
    }

    public static int setAmount(long pay, int price) {
        return (int) (pay / price);
    }

    private static double setTotalEarningMoney(Winningstatistics winningstatistics) {
        double totalEarningMoney = 0;
        for (Rank rankKey : winningstatistics.getStatisticsMap().keySet()) {
            double winningMoney = rankKey.getWinningMoney();
            double userCountOfmatch = winningstatistics.getStatisticsMap().get(rankKey);
            totalEarningMoney += (winningMoney * userCountOfmatch);
        }
        return totalEarningMoney;
    }
}
