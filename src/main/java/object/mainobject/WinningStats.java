package object.mainobject;

import domain.Rank;
import object.WinningLotto;

import java.util.HashMap;
import java.util.Map;

public class WinningStats {
        private final PurchaseInfo purchaseInfo;
        private final WinningLotto winningLotto;
        private final Map<Rank,Integer> stats;

        public WinningStats(PurchaseInfo purchaseInfo, WinningLotto winningLotto){
                this.purchaseInfo = purchaseInfo;
                this.winningLotto = winningLotto;
                stats = new HashMap<Rank,Integer>()
                stats.put(Rank.FIRST,0);
                stats.put(Rank.SECOND,0);
                stats.put(Rank.THIRD,0);
                stats.put(Rank.FOURTH,0);
                stats.put(Rank.FIFTH,0);
                stats.put(Rank.MISS,0);
        }

        public void makeWinningStats(){
                purchaseInfo
        }
}
