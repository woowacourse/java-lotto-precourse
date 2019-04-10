package domain;

import java.util.List;

public class Statistic {

    private int resultOfRank[];
    private List<Rank> rankList;
    private double reward;
    private int money;

    Statistic(List<Rank> rankList, int money) {
        resultOfRank = new int[8];
        this.rankList = rankList;
        this.money = money;
    }

    private void statistic() {
        for (Rank rank : rankList) {
            CountOfRank(rank);
        }
    }
    private void CountOfRank(Rank rank) {
        if (Rank.SECOND == rank || Rank.FIRST == rank) {
            resultOfRank[rank.getCountOfMatch() + 1]++;
            return;
        }
        resultOfRank[rank.getCountOfMatch()]++;
    }
}
