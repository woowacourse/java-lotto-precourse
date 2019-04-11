package object.mainobject;

import creator.PurchsedLottoNumberCreator;
import domain.Rank;
import object.Lotto;
import object.WinningLotto;
import util.InputUtil;
import util.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PurchaseInfo {

        private static final int oneOfLottoAmount = 1000;
        private static final long maxOfLottoAmount = 10_000_000_000l;
        private static final long mismatchEorr = -999_999_999_999l;
        private long purchaseAmount;
        private final List<Lotto> lottos;

        public PurchaseInfo() {
                do {
                        PrintUtil.printPurchaseAmountInputMessage();
                        this.purchaseAmount = InputUtil.inputPurchaseAmount();
                } while (this.purchaseAmount == mismatchEorr
                        || !checkInputPurchaseAmount(this.purchaseAmount)
                        || !checkInputPurchaseAmountOneLotto(this.purchaseAmount));
                this.lottos = purchaseLottos();
        }

        public void printPurchasedLottosNumber() {
                PrintUtil.printPurchaseConfirmMessage(this.purchaseAmount / oneOfLottoAmount);
                PrintUtil.printPurchasedLottoList(this.lottos);
        }

        public Map<Rank, Integer> makeWinningStats(Map<Rank, Integer> stats, WinningLotto winningLotto) {
                for (Lotto lotto : this.lottos) {
                        Rank rank = winningLotto.match(lotto);
                        stats.put(rank, stats.get(rank) + 1);
                }
                return stats;
        }

        public double makeYiend(long revenue) {
                return (double) revenue / this.purchaseAmount;
        }

        private List<Lotto> purchaseLottos() {
                List<Lotto> lottos = new ArrayList<Lotto>();
                PurchsedLottoNumberCreator creator = new PurchsedLottoNumberCreator();
                for (long i = 0; i < this.purchaseAmount / oneOfLottoAmount; i++) {
                        lottos.add(creator.create());
                }
                return lottos;
        }

        private boolean checkInputPurchaseAmount(long input) {
                if (input < 0) {
                        System.err.println("음수 입력 오류");
                        return false;
                }
                if (input > maxOfLottoAmount) {
                        System.err.println("최대 구입 가격 초과 오류");
                        return false;
                }
                return true;
        }

        private boolean checkInputPurchaseAmountOneLotto(long input) {
                if (input >= 0 && input < 1000) {
                        System.err.println("0장 구매 오류");
                        return false;
                }
                return true;
        }
}
