package domain;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    private Map<Rank, Integer> stats = new HashMap<>();

    public void put(Rank r) {
        stats.putIfAbsent(r, 0);
        stats.put(r, stats.get(r) + 1);
    }

    public int getCountOfWinning(Rank r) {
        stats.putIfAbsent(r, 0);
        return stats.get(r);
    }

    /**
     * @param unitPrice 복권의 장당 단가
     * @return 수익률, 0 이상 미만 1 사이의 부동소수점수
     */
    public double calculateEarningRate(int unitPrice) {
        long totalEarned = calculateTotalEarned();
        int countOfLotto = calculateCountOfLotto();

        if (countOfLotto == 0) {
            return 0;
        }

        return totalEarned / (double) (countOfLotto * unitPrice);
    }

    private int calculateCountOfLotto() {
        int count = 0;
        for (Rank r : stats.keySet()) {
            count += stats.get(r);
        }
        return count;
    }

    private long calculateTotalEarned() {
        long sum = 0;
        for (Rank r : stats.keySet()) {
            sum += (long) r.getWinningMoney() * stats.get(r);
        }
        return sum;
    }
}
