import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private List<Rank> lottoRanks = new ArrayList<>();

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        for(Lotto lotto : lottos) {
            lottoRanks.add(winningLotto.match(lotto));
        }
    }

    public int getMatchCount(Rank rank) {
        int matchSumCount = 0;
        for(Rank lottorank : lottoRanks) {
            if(lottorank == rank)
                matchSumCount++;
        }

        return matchSumCount;
    }

    private long getInvestMoney() {
        return lottoRanks.size() * LottoGenerator.UNIT_PRICE;
    }

    public double getRateOfProfit() {
        return (double)getTotalWinningMoney() / getInvestMoney();
    }

    public long getTotalWinningMoney() {
        long totalWinningMoney = 0;
        for(Rank rank : lottoRanks) {
            totalWinningMoney+=rank.getWinningMoney();
        }

        return totalWinningMoney;
    }

    public List<Rank> getLottoRanks() {
        return lottoRanks;
    }
} 
