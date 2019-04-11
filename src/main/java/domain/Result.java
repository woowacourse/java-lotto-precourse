package domain;

import java.util.HashMap;
import java.util.List;

public class Result {
    private List<Lotto> lotto;
    private int myMoney;
    private int sumMoney;
    private WinningLotto winninglotto;
    private User user;
    private HashMap<Rank,Integer> lottoMap;
    public void buyLotto() {
        user = new User();
        myMoney = user.getBudget();
        lotto = user.getLotto(myMoney);
        for (Lotto getlotto : lotto) {
            System.out.println(getlotto.getNumbers());
        }
        List<Integer> getwinLotto = user.getWinningLotto();
        setWinningLotto(getwinLotto);
        System.out.println("총 수익률은 " + setRate() + "입니다.");
    }
    private void setWinningLotto(List<Integer> getwinLotto) {
        int bonusno = user.getBonusNo();
        Lotto winlotto = new Lotto(getwinLotto);

        winninglotto = new WinningLotto(winlotto, bonusno);
        lottoMap = new HashMap<Rank, Integer>();
        for (Rank rank : Rank.values()) {
            lottoMap.put(rank, 0);
        }
        checkStatistics();
    }
    private void checkStatistics() {
        for (Lotto lot : lotto) {
            Rank rank = winninglotto.match(lot);
            lottoMap.put(rank, lottoMap.get(rank) + 1);
            sumMoney += (int) winninglotto.match(lot).getWinningMoney();
        }
        System.out.println("당첨통계");
        System.out.println("============");
        for(Rank rank : Rank.values()) {
            checkMiss(rank);
        }

    }
    private void checkMiss(Rank rank) {
        if (rank != Rank.MISS) {
            checkRank(rank);
        }
    }
    private void checkRank(Rank rank) {
        System.out.print(rank.getCountOfMatch() + "개 일치");
        if (rank == Rank.SECOND) {
            System.out.print(", 보너스 볼 일치 ");
        }
        System.out.print("(" + rank.getWinningMoney() + "원)- ");
        System.out.println(lottoMap.get(rank) + "개");
    }

    private double setRate() {
        return (float) sumMoney / (float)myMoney;
    }

}

