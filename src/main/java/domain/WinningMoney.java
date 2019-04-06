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

    private List<Integer> counterMoney = Arrays.asList(0, 0, 0, 0, 0);

    public int setCountMoney(int money){
        int index = WINNING_MONEY.indexOf(money);
        counterMoney.set(index, counterMoney.get(index)+1);
        return counterMoney.get(index);
    }
}
