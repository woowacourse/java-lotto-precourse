package domain;

import java.util.List;

import static domain.Constant.*;

public class Calculator {

    public static int CalculateMatchCountPerRank(Rank rank, List<Rank> userRanks){
        int matchCountPerRank = (int) userRanks.stream().filter(r -> r == rank).count();

        return matchCountPerRank;
    }

    public static double CalculateEarningRate(List<Rank> userRanks, int purchaseAmount){
        int sumOfPrize = userRanks.stream()
                .filter(ur -> ur.getWinningMoney() > ZERO)
                .mapToInt(ur -> ur.getWinningMoney())
                .sum();

        double earningRate = sumOfPrize / (double) purchaseAmount;

        return earningRate;
    }
}
