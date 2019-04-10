package object.mainobject;

import domain.Rank;
import object.WinningLotto;

import java.util.HashMap;
import java.util.Map;

public class WinningStats {
        private final PurchaseInfo purchaseInfo;
        private final WinningLotto winningLotto;
        private final Map<Rank, Integer> stats;

        public WinningStats(PurchaseInfo purchaseInfo, WinningLotto winningLotto) {
                this.purchaseInfo = purchaseInfo;
                this.winningLotto = winningLotto;
                this.stats = new HashMap<Rank, Integer>()
                this.stats.put(Rank.FIRST, 0);
                this.stats.put(Rank.SECOND, 0);
                this.stats.put(Rank.THIRD, 0);
                this.stats.put(Rank.FOURTH, 0);
                this.stats.put(Rank.FIFTH, 0);
                this.stats.put(Rank.MISS, 0);
        }

        public void makeWinningStats() {
                purchaseInfo.makeWinningStats(this.stats, this.winningLotto);
        }
}
