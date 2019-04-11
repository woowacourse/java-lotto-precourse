package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.Constant.*;

/**
 * 수익률, 로또당 일치개수등을 계산하는 역할을 하는 클래스
 */
public class Calculator {

    public static int CalculateMatchCountPerRank(Rank rank, List<Rank> userRanks) {
        int matchCountPerRank = (int) userRanks.stream().filter(r -> r == rank).count();

        return matchCountPerRank;
    }

    public static double CalculateEarningRate(List<Rank> userRanks, int purchaseAmount) {
        int sumOfPrize = userRanks.stream()
                .filter(ur -> ur.getWinningMoney() > ZERO)
                .mapToInt(ur -> ur.getWinningMoney())
                .sum();

        double earningRate = sumOfPrize / (double) purchaseAmount;

        return earningRate;
    }

    public static List<Rank> MatchLottoNumbers() {
        WinningLotto winningLotto = LottoGenerator.getWinningLotto();
        List<Lotto> lottoes = LottoGenerator.getLottoList();
        List<Rank> ranks = new ArrayList<>();

        for (int i = 0; i < lottoes.size(); i++) {
            Rank rank = winningLotto.match(lottoes.get(i));
            ranks.add(rank);
        }

        return ranks;
    }
}
