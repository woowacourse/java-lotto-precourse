package object.mainobject;

import domain.Rank;
import object.WinningLotto;

import java.util.HashMap;
import java.util.Map;

public class WinningStats {
        private final PurchaseInfo purchaseInfo;
        private final WinningLotto winningLotto;
        private Map<Rank, Integer> stats;
        private long revenue;
        private double yield;

        public WinningStats(PurchaseInfo purchaseInfo, WinningLotto winningLotto) {
                this.purchaseInfo = purchaseInfo;
                this.winningLotto = winningLotto;
                this.stats = new HashMap<Rank, Integer>();
                for(Rank rank : Rank.values()){
                        this.stats.put(rank,0);
                }
                revenue = 0;
                yield = 0;
        }

        public void makeWinningStats() {
                purchaseInfo.makeWinningStats(this.stats, this.winningLotto);
        }

        public void makeYield(){
                for(Rank rank : Rank.values()){
                        this.revenue += this.stats.get(rank) * rank.getWinningMoney();
                }
                this.yield = purchaseInfo.makeYiend(this.revenue);
        }
}
