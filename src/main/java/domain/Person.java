package domain;

import java.util.List;

public class Person {
    private final int BUDGET_MIN_LIMIT = 0;
    private final int LOTTO_PRICE = 1000;

    private int budget;
    private int prizeMoney;
    private List<Lotto> myLotto;

    public Person() {
        prizeMoney = 0;
    }

    public boolean setBudget(int budget) {
        if (budget < BUDGET_MIN_LIMIT) {
            System.out.println("마이너스 통장을 갖고 있어서 로또를 살 수 없습니다.");
            return false;
        }
        this.budget = budget;

        return true;
    }

    public int payBudget() {
        return budget;
    }

    public void keepLotto(List<Lotto> lottoList) {
        this.myLotto = lottoList;
    }

    public int[] checkRank(WinningLotto winningLotto) {
        int[] rankCounter = new int[6];
        Rank rank;

        for (Lotto lotto : myLotto) {
            rank = winningLotto.match(lotto);
            rankCounter[convertRankToIndex(rank)]++;
            prizeMoney += rank.getWinningMoney();
        }

        return rankCounter;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMoneySpent() {
        return (budget / LOTTO_PRICE) * LOTTO_PRICE;
    }

    public int convertRankToIndex(Rank rank) {
        if (rank.equals(Rank.MISS))
            return 0;
        if (rank.equals(Rank.FIFTH) || rank.equals(Rank.FOURTH))
            return rank.getCountOfMatch() - 2;
        if (rank.equals(Rank.THIRD))
            return 3;
        if (rank.equals(Rank.SECOND))
            return 4;
        return 5;
    }
}
