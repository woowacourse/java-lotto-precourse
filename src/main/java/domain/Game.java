package domain;

import creator.WinningLottoCreator;
import object.mainobject.PurchaseInfo;
import object.WinningLotto;
import object.mainobject.WinningStats;

public class Game {
        Game() {
        }

        public void start() {
                PurchaseInfo purchaseInfo = new PurchaseInfo();
                purchaseInfo.printPurchasedLottosNumber();
                WinningLottoCreator creator = new WinningLottoCreator();
                WinningLotto winningLotto = creator.create();
                WinningStats winningStats = new WinningStats(purchaseInfo, winningLotto);

                winningStats.printStats();
        }
}
