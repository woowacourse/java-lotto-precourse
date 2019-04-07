package domain;

import java.util.List;

public class Profit {

    private int money;
    private int numberOfUserLottoTickets;
    private static final Rank[] ranks = Rank.values();

    public static double calculateProfitRate(int [] countRanks, int money){
        long sum = 0;
        for(int i = 0; i < countRanks.length; i++){
            sum = sum + (countRanks[i] * ranks[i].getWinningMoney());
        }
        System.out.println("Sum is " + sum );
        double profitRate = sum / (double)money;
        return profitRate;
    }
}
