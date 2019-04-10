package domain;

import java.util.*;

public class Profit {

    private static final int FIFTH_INDEX = 1;
    private static final Rank[] RANKS = Rank.values();
    private static final List<Rank> USER_RANKS = new ArrayList<>();
    private static final Map<Rank, Integer> COUNT_RANKS = new HashMap<>();

    private static double profitRate = 0;

    public static void initMap() {
        for (int i = 0; i < RANKS.length; i++) {
            COUNT_RANKS.put(RANKS[i], new Integer(0));
        }
    }

    public static void addUserRanks(Rank rank) {
        USER_RANKS.add(rank);
    }

    public static void calculateRank() {
        USER_RANKS.forEach((rank -> {
            int count = COUNT_RANKS.get(rank) + 1;
            COUNT_RANKS.replace(rank, count);
        }));
    }

    public static void calculateProfitRate(int money) {
        final Long[] sum = new Long[1];
        sum[0] = (long) 0;
        COUNT_RANKS.forEach((rank, count) -> {
            sum[0] = sum[0] + rank.getWinningMoney() * count;
        });
        profitRate = sum[0] / (double) money;
    }

    public static void showStatistics() {
        List<Rank> rankList = Arrays.asList(RANKS);
        Collections.reverse(rankList);
        for (int i = FIFTH_INDEX; i < rankList.size(); i++) {
            System.out.println(rankList.get(i).getCountOfMatch() + "개 일치 (" + rankList.get(i).getWinningMoney() + "원)- " + COUNT_RANKS.get(rankList.get(i)) + "개");
        }
    }

    public static void showProfitRate(int money) {
        calculateProfitRate(money);
        System.out.println("총 수익륭은 " + profitRate + "입니다.");
    }
}
