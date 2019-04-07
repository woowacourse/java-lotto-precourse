package domain;

import java.util.ArrayList;
import java.util.List;

public class ResultInfomation {
    private List<Rank> ranks = new ArrayList<>();
    private int money;

    private static final int MIN_MONEY = 1000;

    ResultInfomation(List<Rank> ranks) {
        this.ranks = ranks;
        this.money = ranks.size() * MIN_MONEY;
    }
}
