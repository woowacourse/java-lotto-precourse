package domain;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private static final int INIT_COUNT = 0;
    private static final int COUNTING = 1;
    private WinningLotto winningLotto;
    private LottoTickets lottoTickets;
    private Map<Rank, Integer> statistics = new HashMap<>();

    public LottoStatistics(WinningLotto winningLotto, LottoTickets lottoTickets) {
        this.winningLotto = winningLotto;
        this.lottoTickets = lottoTickets;
        initStatistics();
        calculateStatistics();
    }

    private void initStatistics() {
        for (Rank rank : Rank.values()) {
            statistics.put(rank, INIT_COUNT);
        }
    }

    private void calculateStatistics() {
        for (Lotto ticket : lottoTickets.getTickets()) {
            Rank rank = winningLotto.match(ticket);
            statistics.put(rank, statistics.get(rank) + COUNTING);
        }
    }

    private double calculateReturnRate() {
        long totalProfit = 0;
        for (Rank rank : Rank.values()) {
            totalProfit += ((long) rank.getWinningMoney()) * statistics.get(rank);
        }
        long investment = lottoTickets.getTickets().size() * Lotto.PRICE;
        return (double) totalProfit / investment;
    }

    public void show() {
        DecimalFormat formatter = new DecimalFormat("#0.000");
        System.out.println("\n당첨 통계");
        System.out.println("---------------------------------------");
        System.out.println("3개 일치 (5,000원) - " + statistics.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.get(Rank.FIRST) + "개");
        System.out.println("총 수익률은 " + formatter.format(calculateReturnRate()) + "입니다.");
    }
}
