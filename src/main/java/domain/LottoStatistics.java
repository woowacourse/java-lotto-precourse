package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 당첨 확인된 로또들의 rank 를 통해
 * 당첨 통계를 구한다.
 */
public class LottoStatistics {

    private List<Integer> numberOfMatches;

    public void addWinStats(List<Rank> rankList) {
        numberOfMatches = new ArrayList<>();

        for (Rank rank : rankList) {
            numberOfMatches.add(rank.getWinningMoney());
        }
    }

    public void printStatistic() {
        printWinStats();
        printTotalYield();
    }

    private void printWinStats() {
        int winningMoney;
        List<Rank> rankList = Arrays.asList(Rank.FIFTH, Rank.FOURTH
                , Rank.THIRD, Rank.SECOND, Rank.FIRST);

        for (Rank rank : rankList) {
            winningMoney = rank.getWinningMoney();
            System.out.format("%d개 일치(%s)원 - %d개\n", rank.getCountOfMatch()
                    , winningMoney, countMatchedLotto(winningMoney));
        }
    }

    private int countMatchedLotto(int winningMoney) {
        int result;
        List<Integer> copyNumberOfMatches = new ArrayList<>(numberOfMatches);

        copyNumberOfMatches.remove((Integer) winningMoney);
        result = numberOfMatches.size() - copyNumberOfMatches.size();

        return result;
    }

    private void printTotalYield() {
        double totalYield;
        double totalRevenue = 0;
        double purchaseAmount = numberOfMatches.size() * Constant.CONVERSION_LOTTO_AND_PRICE;

        for (Integer revenue : numberOfMatches) {
            totalRevenue += revenue;
        }

        totalYield = totalRevenue / purchaseAmount;
        System.out.format("총 수익률은 %.3f 입니다.", totalYield);
    }
}
