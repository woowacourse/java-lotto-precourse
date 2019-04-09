package domain;

import java.lang.reflect.Array;
import java.util.*;

public class LottoResult {
    static final double PERCENTAGE_INTEGER = 100;
    static final int DECIMAL_POINT = 10;
    static final int ROUND_NUMBER = 2;

    static final String INITIAL_WORD = "\n당첨 통계\n---------";
    static final String HOW_MANY = "개 일치 (";
    static final String HOW_MANY_SECOND = "개 일치, 보너스 볼 일치(";
    static final String BETWEEN_WORDS = ")- ";
    static final String COUNT = "개";
    static final String PROFIT_RATE_IS = "총 수익률은 ";
    static final String THIS = "%입니다.";


    Map<Rank, Integer> rankMap;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        initializeRankMap();
        for (Lotto lotto : lottos) {
            incrementValueIfMapHasKey(winningLotto.match(lotto));
        }
    }

    private void initializeRankMap() {
        rankMap = new HashMap<>();
        for (Rank rank : Rank.values()
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
        for (Rank rank : rankMap.keySet()
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
        for (int number : rankMap.values()
        ) {
            total += number;
        }
        return total;
    }


    public void show() {
        System.out.println(INITIAL_WORD);
        for (Rank rank : getRankListWithoutMISSinReversedOrder()
        ) {
            String string = stringOfOneRankResult(rank);
            System.out.println(string);
        }

        showLottoProfitRate();
    }

    private void showLottoProfitRate() {
        System.out.println(PROFIT_RATE_IS + roundAt(calculateProfitRate(),
                ROUND_NUMBER) + THIS);
    }

    private String stringOfOneRankResult(Rank rank) {
        String string = rank.getWinningMoney() + BETWEEN_WORDS + rankMap.get(rank) + COUNT;
        if (rank == Rank.SECOND) {
            string = rank.getCountOfMatch() + HOW_MANY_SECOND + string;
            return string;
        }

        string = rank.getCountOfMatch() + HOW_MANY + string;
        return string;
    }

    private List<Rank> getRankListWithoutMISSinReversedOrder() {
        List<Rank> ranks = new ArrayList<>();
        ranks.addAll(Arrays.asList(Rank.values()));
        ranks.remove(Rank.MISS);
        Collections.reverse(ranks);

        return ranks;
    }

    @Override
    public String toString() {
        return rankMap.toString();
    }
}
