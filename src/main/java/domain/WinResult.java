package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WinResult {

    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private List<Integer> numberOfMatches;

    public WinResult(UserLotto userLotto, WinningLotto winningLotto) {
        this.userLotto = userLotto;
        this.winningLotto = winningLotto;
        numberOfMatches = new ArrayList<>();
    }

    public void checkResult() {
        checkHowManyMatch();
        printWinResult();
    }

    private void checkHowManyMatch() {
        List<Lotto> userLottoList = userLotto.getUserLottoList();

        Iterator<Lotto> iter = userLottoList.iterator();
        while (iter.hasNext()) {
            addWinStats(iter.next());
        }
    }

    private void addWinStats(Lotto lotto) {
        Rank rank = winningLotto.match(lotto);

        numberOfMatches.add(rank.getWinningMoney());
    }

    private void printWinResult() {
        printWinStats();
        printTotalYield();
    }

    private void printWinStats() {
        int countOfMatch;
        int winningMoney;
        List<Rank> rankList = Arrays.asList(Rank.FIFTH, Rank.FOURTH,
                Rank.THIRD, Rank.SECOND, Rank.FIRST);

        for (Rank rank : rankList) {
            countOfMatch = rank.getCountOfMatch();
            winningMoney = rank.getWinningMoney();
            System.out.format("%d개 일치(%s)원 - %d개\n", countOfMatch
                    , winningMoney, calculateCountMatchedLotto(winningMoney));
        }
    }

    private int calculateCountMatchedLotto(int winningMoney) {
        int countMatchedLotto;
        List<Integer> copyNumberOfMatches = new ArrayList<>(numberOfMatches);
        copyNumberOfMatches.remove((Integer) winningMoney);

        countMatchedLotto = numberOfMatches.size() - copyNumberOfMatches.size();
        return countMatchedLotto;
    }

    private void printTotalYield() {
        double totalYield;
        double totalRevenue = 0;
        double purchaseAmount = numberOfMatches.size() * ConstValue.CONVERSION_COUNT_AND_MONEY;

        for (Integer revenue : numberOfMatches) {
            totalRevenue += revenue;
        }

        totalYield = totalRevenue / purchaseAmount;
        System.out.format("총 수익률은 %.3f 입니다.", totalYield);
    }
}
