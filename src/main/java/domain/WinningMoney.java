package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningMoney {
    private static final int MAX_WINNING_NUMBER = 5;
    private static final List<Integer> WINNING_MONEY = new ArrayList<Integer>(){
        {
            add(Rank.FIFTH.getWinningMoney());
            add(Rank.FOURTH.getWinningMoney());
            add(Rank.THIRD.getWinningMoney());
            add(Rank.SECOND.getWinningMoney());
            add(Rank.FIRST.getWinningMoney());
        }
    };

    public int getWinningMoney(int n){
        return WINNING_MONEY.get(n);
    }
}
