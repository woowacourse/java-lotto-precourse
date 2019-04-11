import domain.Lotto;
import domain.LottoAnalyzer;
import domain.Rank;
import domain.WinningLotto;

import java.util.HashMap;
import java.util.List;

public class MyLottoAnalyzer implements LottoAnalyzer {
    private static final Rank[] ranksForPrint = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};

    @Override
    public void analyze(WinningLotto winningLotto, List<Lotto> lottos, int usedMoney) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        var counter = _initCounter(winningLotto, lottos);
        System.out.println(generateMatchStr(counter));

        System.out.printf("총 수익률은 %f입니다.", (double) countTotalWinningMoney(counter) / usedMoney);
    }

    private HashMap<Rank, Integer> _initCounter(WinningLotto winningLotto, List<Lotto> lottos) {
        var counter = new HashMap<Rank, Integer>();

        for (var lotto : lottos) {
            var rank = winningLotto.match(lotto);

            var cnt = counter.getOrDefault(rank, 0);
            counter.put(rank, cnt + 1);
        }
        return counter;
    }

    private String generateMatchStr(HashMap<Rank, Integer> counter) {
        var sb = new StringBuilder();
        for (var r : ranksForPrint) {
            sb.append(String.format("%d개 일치%s ", r.getCountOfMatch(), r == Rank.SECOND ? ", 보너스 볼 일치" : ""));
            sb.append(String.format("(%d원)", r.getWinningMoney()));
            sb.append(String.format("- %d개\n", counter.getOrDefault(r, 0)));
        }
        return sb.toString();
    }

    private long countTotalWinningMoney(HashMap<Rank, Integer> counter) {
        long total = 0;

        for (var r : counter.keySet()) {
            long winningMoney = r.getWinningMoney();
            total += winningMoney * counter.get(r);
        }

        return total;
    }
}
