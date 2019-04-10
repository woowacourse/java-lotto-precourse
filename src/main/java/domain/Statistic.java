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
}
