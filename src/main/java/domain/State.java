package domain;

import lotto.Rank;

import java.util.List;
import java.util.TreeMap;

import static constants.LottoConstants.LOTTO_PRICE;

public class State {
    public TreeMap<Rank, Long> statsLottoResult(List<Rank> ranks) {
        TreeMap<Rank, Long> stats = new TreeMap<>();

        for (Rank value : Rank.values()) {
            stats.put(value, ranks.stream().filter(rank -> rank == value).count());
        }

        return stats;
    }

    double returnOfRate(TreeMap<Rank, Long> stats) {
        double totalMoney = stats.values().stream().mapToInt(Long::intValue).sum() * LOTTO_PRICE;
        double returnMoney = 0;

        for (Rank rank : Rank.values()) {
            returnMoney += rank.getWinningMoney() * stats.get(rank);
        }

        return returnMoney / totalMoney;
    }
}