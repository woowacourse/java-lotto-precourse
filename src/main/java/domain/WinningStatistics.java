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
        long moneyTotalEarned = calculateTotalEarned();
        int countOfLotto = calculateCountOfLotto();

        if (countOfLotto == 0) {
            return 0;
        }

        return  moneyTotalEarned / (double) (countOfLotto * unitPrice);
    }

    private int calculateCountOfLotto() {
        int count = 0;
        for (Rank r : stats.keySet()) {
            count += stats.get(r);
        }
        return count;
    }

    /**
     *
     * @return 당첨금 총액을 반환, 1등이 여러 번 되는 경우를 고려하여 long 타입 사용.
     */
    private long calculateTotalEarned() {
        long sum = 0;
        for (Rank r : stats.keySet()) {
            sum += (long) r.getWinningMoney() * stats.get(r);
        }
        return sum;
    }
}
