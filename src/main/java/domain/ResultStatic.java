package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResultStatic {
    private static final int INITIAL_RESULT_VALUE = 0;
    private static final int LOTTO_PRICE = 1_000;
    private static final double PERCENT_MODIFIER = 100;

    private Map<Rank, Integer> result = new LinkedHashMap<>();
    private double earningRate;

    public ResultStatic() {
        result.put(Rank.FIFTH, INITIAL_RESULT_VALUE);
        result.put(Rank.FOURTH, INITIAL_RESULT_VALUE);
        result.put(Rank.THIRD, INITIAL_RESULT_VALUE);
        result.put(Rank.SECOND, INITIAL_RESULT_VALUE);
        result.put(Rank.FIRST, INITIAL_RESULT_VALUE);
    }

    public void putResult(Rank rank) {
        if (rank != Rank.MISS) {
            result.put(rank, result.get(rank) + 1);
        }
    }

    public void calculateEarningRate(int numberOfLottos) {
        double cumulativeEarning = 0;

        for (Rank key : result.keySet()) {
            cumulativeEarning += key.getWinningMoney() * result.get(key);
        }

        earningRate = cumulativeEarning / ((double) numberOfLottos * LOTTO_PRICE) * PERCENT_MODIFIER;
    }

    public void showResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank key : result.keySet()) {
            System.out.print(key.getCountOfMatch() + "개 일치");
            if (key == Rank.SECOND) System.out.print(", 보너스 볼 일치");
            System.out.print(" ("+ key.getWinningMoney() + "원)- " + result.get(key) + "개\n");
        }
        System.out.println("총 수익률은 " + String.format("%,.2f", earningRate) + "% 입니다.");
    }
}
