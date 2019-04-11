/*
 *@(#)Game.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package domain;

import creator.WinningLottoCreator;
import object.mainobject.PurchaseInfo;
import object.WinningLotto;
import object.mainobject.WinningStats;

/**
 * 로또게임의 전반적인 진행을 하는 클래스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
 */

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
