/*
 *@(#)WinningStats.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package object.mainobject;

import domain.Rank;
import object.WinningLotto;
import util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 로또 게임에서 당첨 통계에 대한 정보를 가지고 있고
 * 그에 대한 기능을 하는 클래스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
 */

public class WinningStats {
        private final PurchaseInfo purchaseInfo;
        private final WinningLotto winningLotto;
        private Map<Rank, Integer> stats;
        private long revenue = 0;
        private double yield = 0;

        public WinningStats(PurchaseInfo purchaseInfo, WinningLotto winningLotto) {
                this.purchaseInfo = purchaseInfo;
                this.winningLotto = winningLotto;
                this.stats = new HashMap<Rank, Integer>();
                for (Rank rank : Rank.values()) {
                        this.stats.put(rank, 0);
                }
                revenue = 0;
                yield = 0;
                makeWinningStats();
        }

        public void makeWinningStats() {
                this.stats = purchaseInfo.makeWinningStats(this.stats, this.winningLotto);
                makeYield();
        }

        public void makeYield() {
                for (Rank rank : Rank.values()) {
                        this.revenue += this.stats.get(rank) * rank.getWinningMoney();
                }
                this.yield = purchaseInfo.makeYiend(this.revenue);
        }

        public void printStats() {
                PrintUtil.printWinningStats(this.stats);
                PrintUtil.printYiend(this.yield);
        }
}
