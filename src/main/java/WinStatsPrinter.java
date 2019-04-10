import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class WinStatsPrinter {
    public static void printWinStats(WinningLotto winningLotto, LottoBuyer buyer){
        System.out.println("\n당첨통계");
        System.out.println("---------");
        List<Rank> list = getRankList(winningLotto,buyer);
        double income = getSumOfWinningMoney(list);
        System.out.println("총 수익률은 "+income/buyer.getInitMoney()+"입니다.");
    }

    private static List<Rank> getRankList(WinningLotto winningLotto, LottoBuyer buyer){
        List<Rank> list = new ArrayList<>();
        for(Lotto lotto : buyer.getLottoList()){
            Rank rank = winningLotto.match(lotto);
            list.add(rank);
        }
        return list;
    }

    private static int getSumOfWinningMoney(List<Rank> list){
        int sum=0;
        int[] arr = new int[Rank.values().length];
        for(Rank rank : list){
            sum+=rank.getWinningMoney();
            arr[rank.ordinal()]++;
        }
        printRankStats(arr);
        return sum;
    }

    private static void printRankStats(int[] arr){
        for(int i=4; i>=0; i--){
            Rank rank = getRankByIdx(i);
            String prefix = String.valueOf(rank.getCountOfMatch())+"개 일치";
            prefix += (i==1)?", 보너스 볼 일치":" ";
            System.out.println(prefix+"("+rank.getWinningMoney()+")- "+arr[i]+"개");
        }
    }

    private static Rank getRankByIdx(int idx){
        Rank result=Rank.MISS;
        for(Rank rank : Rank.values()){
            if(rank.ordinal() == idx) result=rank;
        }
        return result;
    }

}
