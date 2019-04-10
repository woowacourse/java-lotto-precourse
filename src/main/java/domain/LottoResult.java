package domain;

import java.util.Map;
import java.util.TreeMap;

public class LottoResult {
    private static final int BASE_AMOUNT = 0;
    private static final int UPDATE_AMOUNT = 1;

    private Map<Rank, Integer> lottoResults = new TreeMap<>();

    private LottoResult() {
        for (Rank rank : Rank.values()) {
            lottoResults.put(rank, BASE_AMOUNT);
        }
    }

    Map<Rank, Integer> getLottoResults() {
        return lottoResults;
    }

    private static class LottoResultHolder {
        static final LottoResult INSTANCE = new LottoResult();
    }

    static LottoResult getInstance() {
        return LottoResultHolder.INSTANCE;
    }

    void insertResult(Rank rank) {
        int updateNumber = lottoResults.get(rank) + UPDATE_AMOUNT;
        lottoResults.put(rank, updateNumber);
    }

    String calculateEarningRate(int money) {
        long totalMoney = getTotalMoney();
        return String.format("%.4f", (float) totalMoney / money);
    }

    private long getTotalMoney() {
        long totalMoney = 0;
        for (Rank rank : lottoResults.keySet()) {
            int rankMoney = rank.getWinningMoney();
            int rankCount = lottoResults.get(rank);
            totalMoney += (long) rankMoney * rankCount;
        }
        return totalMoney;
    }
}
