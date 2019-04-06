package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningMoney {
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

    public void setCountMoney(int money){
        int index = WINNING_MONEY.indexOf(money);
        counterMoney.set(index, counterMoney.get(index)+1);
    }

    public void printCountMoney(){
        System.out.println("당첨 통계\n---------");
        System.out.printf("3개 일치(%d원)- %d개\n", WINNING_MONEY.get(0), counterMoney.get(0));
        System.out.printf("4개 일치(%d원)- %d개\n", WINNING_MONEY.get(1), counterMoney.get(1));
        System.out.printf("5개 일치(%d원)- %d개\n", WINNING_MONEY.get(2), counterMoney.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치(%d원)- %d개\n", WINNING_MONEY.get(3), counterMoney.get(3));
        System.out.printf("6개 일치(%d원)- %d개\n", WINNING_MONEY.get(4), counterMoney.get(4));
    }
}
