package com.molt3nrock.lotto;

import static com.molt3nrock.lotto.Constants.PRICE_PER_LOTTO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Statistics {

    private Map<Rank, Integer> rankState;

    private Statistics(Map<Rank, Integer> rankState) {
        this.rankState = rankState;
    }

    static Statistics valueOf(List<Lotto> lottoList, WinningLotto winningLotto) {
        HashMap<Rank, Integer> hashMap = new HashMap<>();
        Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.MISS)
            .forEach(rank -> hashMap.putIfAbsent(rank, 0));
        Statistics statistics = new Statistics(hashMap);
        lottoList.forEach(lotto -> statistics.classifyLotto(lotto, winningLotto));
        return statistics;
    }

    int numberOfRank(Rank rank) {
        assert (rankState.containsKey(rank));
        return rankState.get(rank);
    }

    void displayRankState() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        rankState.entrySet().stream()
            .filter(entry -> !entry.getKey().equals(Rank.MISS))
            .map(Statistics::formatRankStateEntry)
            .forEach(System.out::println);
    }

    void displayRossGainRation() {
        System.out.println(String.format("총 수익률은 %.3f입니다.", calculateRossRatio()));
    }

    void displayStatistics() {
        displayRankState();
        displayRossGainRation();
    }

    private float calculateRossRatio() {
        int totalGain = rankState.entrySet().stream()
            .map(entry -> entry.getValue() * entry.getKey().getWinningMoney())
            .reduce(0, (accumulation, prizeMoney) -> accumulation + prizeMoney);
        int totalCost = rankState.values().stream()
            .reduce(0, (accumulation, count) -> accumulation + count * PRICE_PER_LOTTO);
        return (float) totalGain / totalCost;
    }

    private static String formatRankStateEntry(Entry<Rank, Integer> entry) {
        return String.format("%s- %d개", entry.getKey(), entry.getValue());
    }

    private void classifyLotto(Lotto lotto, WinningLotto winningLotto) {
        Rank rank = winningLotto.match(lotto);
        rankState.computeIfPresent(rank, (rankKey, count) -> count + 1);
    }
}
