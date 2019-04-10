package object.mainobject;

import domain.Rank;

import java.util.HashMap;
import java.util.Map;

public class WinningStats {
        private final PurchaseInfo purchaseInfo;
        private final Map<Rank,Integer> stats;

        public WinningStats(PurchaseInfo purchaseInfo){
                this.purchaseInfo = purchaseInfo;
                stats = new HashMap<Rank,Integer>()
                stats.put(Rank.FIRST,0);
                stats.put(Rank.SECOND,0);
                stats.put(Rank.THIRD,0);
                stats.put(Rank.FOURTH,0);
                stats.put(Rank.FIFTH,0);
                stats.put(Rank.MISS,0);
        }

        public void makeWinningStats(){
                purchaseInfo.makeWinningStats(this.stats);
        }
}
