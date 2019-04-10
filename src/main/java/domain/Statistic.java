package domain;

import java.util.List;

import static domain.Message.STATISTIC_MESSAGE;

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
    public void print() {
        System.out.println(STATISTIC_MESSAGE);
        statistic();
        for (int i = 3; i <= 7; i++) {
            Rank rank = Rank.valueOf((i >= 6 ? (i - 1) : i), (i == 6));
            System.out.format(i == 6 ? Message.MATCH_MESSAGE_BONUS : Message.MATCH_MESSAGE, (i >= 6 ? i - 1 : i), rank.getWinningMoney(), resultOfRank[i]).toString();
            reward += rank.getWinningMoney() * resultOfRank[i];
        }
        printReward();
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
