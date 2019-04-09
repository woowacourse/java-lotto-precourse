package domain;

import java.util.*;

public class Profit {

    private static final Rank[] ranks = Rank.values();
    private static final List<Rank> userRanks = new ArrayList<>();
    private static final Map<Rank, Integer> countRanks = new HashMap<>();

    private static double profitRate = 0;

    public static void initMap() {
        for (int i = 0; i < ranks.length; i++) {
            countRanks.put(ranks[i], new Integer(0));
        }
    }

    public static void addUserRanks(Rank rank) {
        userRanks.add(rank);
    }

    public static void calculateRank() {
        userRanks.forEach((rank -> {
            int count = countRanks.get(rank) + 1;
            countRanks.replace(rank, count);
        }));
    }

    public static void printCountRanks() {
        System.out.println(countRanks);
    }

    public static void calculateProfitRate(int money) {
        final Long[] sum = new Long[1];
        sum[0] = (long) 0;
        countRanks.forEach((rank, count) -> {
            sum[0] = sum[0] + rank.getWinningMoney() * count;
        });
        profitRate = sum[0] / (double) money;
    }

    public static void showStatistics() {
        List<Rank> rankList = Arrays.asList(ranks);
        Collections.reverse(rankList);
        rankList.stream().filter(rank -> rank != Rank.MISS).forEach(
                rank -> {
                    System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + countRanks.get(rank) + "개");
                }
        );
    }

    public static void showProfitRate(int money) {
        calculateProfitRate(money);
        System.out.println("총 수익륭은 " + profitRate + "입니다.");
    }
}
