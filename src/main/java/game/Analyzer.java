package game;

import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;

import java.util.*;

/**
 * 수익률을 계산하는 클래스
 */
public class Analyst {
    // 당첨 통계 구현
    public static final int FIRST_PLACE = 6;
    public static final int FIFTH_PLACE = 3;
    public static final int LOTTO_PRICE = 1000;
    public static List<Lotto> lottos;
    public static WinningLotto winningLotto;
    public static HashMap<Rank, Integer> map;

    public Analyst(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public int GetWinningMoney(int index) {
        return winningLotto.match(lottos.get(index)).getWinningMoney();
    }



    public void showResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        String[] result = putCorrectCount();
        double benefitRate = putBenefitRate();
        for (String value : result) {
            System.out.println(value);
        }
        System.out.println("총 수익률은 " + benefitRate + "입니다.");
    }

    public String[] putCorrectCount() {
        int index = 0;
        setHashMap();
        String[] result = new String[map.size()];
        int[] order = {3, 2, 4, 0, 1};
        for (Rank rank : map.keySet()) {
            result[order[index++]] = tellCorrectCountAndMoney(rank);
        }
        return result;
    }

    public void setHashMap() {
        map = new HashMap<>();
        for (Rank rank : Rank.values()) {
            map.put(rank, 0);
        }
        for (int i = 0; i < lottos.size(); i++) {
            Rank rank = winningLotto.match(lottos.get(i));
            map.replace(rank, map.get(rank) + 1);
        }
        map.remove(Rank.MISS);
    }

    public String tellCorrectCountAndMoney(Rank rank) {
        if (rank == Rank.SECOND) {
            return rank.getCountOfMatch() + "개 일치, 보너스 볼 일치("
                    + rank.getWinningMoney() + "원)- "
                    + map.get(Rank.SECOND) + "개";
        }
        return rank.getCountOfMatch() + "개 일치 ("
                + rank.getWinningMoney() +"원)- "
                + map.get(rank) + "개";
    }

    public double putBenefitRate() {
        int sum = 0;
        for (Rank rank : map.keySet()) {
            int benefit = rank.getWinningMoney() * map.get(rank);
            sum += benefit;
        }
        return (double) sum / (lottos.size() * LOTTO_PRICE);
    }
}
