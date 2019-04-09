package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    static final double PERCENTAGE_INTEGER = 100;
    static final int DECIMAL_POINT = 10;

    Map<Rank, Integer> rankMap;

    public LottoResult (List<Lotto> lottos, WinningLotto winningLotto) {
        initializeRankMap();
        for(Lotto lotto : lottos) {
            incrementValueIfMapHasKey(winningLotto.match(lotto));
        }
    }

    private void initializeRankMap() {
        rankMap = new HashMap<>();
        for ( Rank rank : Rank.values()
             ) {
            rankMap.put(rank, 0);
        }
    }

    private void incrementValueIfMapHasKey(Rank rank) {
        int oldValue = rankMap.get(rank);
        rankMap.put(rank, oldValue + 1);
    }

    private int calculateProfit() {
        int profit = 0;
        for ( Rank rank : rankMap.keySet()
             ) {
            profit += rankMap.get(rank) * rank.getWinningMoney();
        }
        return profit;
    }

    private double calculateProfitRate() {
        double profit = calculateProfit();
        double purchaseAmount = countOfLottos() * Lotto.PRICE;

        return profit / purchaseAmount * PERCENTAGE_INTEGER;
    }

    private double roundAt(double number, int roundPosition) {
        double devidingNumber = Math.pow(DECIMAL_POINT, roundPosition);
        return Math.round(number * devidingNumber) / devidingNumber;
    }

    private int countOfLottos() {
        int total = 0;
        for ( int number : rankMap.values()
             ) {
            total += number;
        }
        return total;
    }

    public void showProfit() {
        System.out.println(calculateProfitRate());
    }


    @Override
    public String toString() {
        return rankMap.toString();
    }
}
