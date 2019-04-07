import domain.*;

import java.util.HashMap;
import java.util.List;

/**
 * 로또 게임 진행을 담당하는 객체
 */
public class LottoGame {
    public HashMap<Lotto, Rank> startLottery(List<Lotto> issuedLottos, WinningLotto winningLotto) {
        HashMap<Lotto, Rank> lotteryResults = new HashMap<Lotto, Rank>();

        for (Lotto lotto: issuedLottos) {
            lotteryResults.put(lotto, winningLotto.match(lotto));
        }
        
        return lotteryResults;
    }

    public static void main(String args[]) {
        LottoGame lottoGame = new LottoGame();
        LottoManager lottoManager = new LottoManager();

        int purchaseAmount = lottoManager.inputPurchaseAmount();
        List<Lotto> issuedLottos = lottoManager.issueLottoOf(purchaseAmount);
        WinningLotto winningLotto = new WinningLotto(lottoManager.inputWinningNumbers(), lottoManager.inputBonus());

        HashMap<Lotto, Rank> lotteryResults = lottoGame.startLottery(issuedLottos, winningLotto);
        lottoManager.showEarningRate(lotteryResults);
    }
}