import domain.*;

import java.util.HashMap;
import java.util.List;

/**
 * 로또 게임 진행을 담당하는 객체
 */
public class LottoGame {
    public HashMap<Lotto, Rank> startLottery(List<Lotto> userLottos, WinningLotto winningLotto) {
        HashMap<Lotto, Rank> lotteryResults = new HashMap<Lotto, Rank>();

        for (Lotto lotto : userLottos) {
            lotteryResults.put(lotto, winningLotto.match(lotto));
        }

        return lotteryResults;
    }

    public static void main(String args[]) {
        LottoGame lottoGame = new LottoGame();
        LottoManager lottoManager = new LottoManager();
        StatisticAnalyzer analyzer = new StatisticAnalyzer();

        List<Lotto> userLottos = lottoManager.issueLottoWorthOf(lottoManager.inputPurchaseAmount());
        WinningLotto winningLotto = new WinningLotto(lottoManager.inputWinningNumbers(), lottoManager.inputBonus());

        HashMap<Lotto, Rank> lotteryResults = lottoGame.startLottery(userLottos, winningLotto);
        HashMap<Rank, Integer> rankDistributionTable = analyzer.analyzeRankDistribution(lotteryResults);
        analyzer.analyzeEarningRatesBy(rankDistributionTable);
    }
}