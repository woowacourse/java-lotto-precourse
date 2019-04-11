/*
 *@(#)WinningLottoCreator.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package creator;

import object.BonusBall;
import object.Lotto;
import object.WinningLotto;

/**
 * 로또게임의 당첨 로또를 생성하는 클래스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
 */

public class WinningLottoCreator implements Creator {
        @Override
        public WinningLotto create() {
                WinningLotto winningLotto = makeWinningLotto();
                return winningLotto;
        }

        private WinningLotto makeWinningLotto() {
                Lotto lotto;
                BonusBall bonusBall;
                LastWeekWinningNumberCreator lastWeekWinningNumberCreator = new LastWeekWinningNumberCreator();
                BonusBallCreator bonusBallCreator = new BonusBallCreator();
                do {
                        lotto = lastWeekWinningNumberCreator.create();
                        bonusBall = bonusBallCreator.create();
                } while (!checkWinningLotto(lotto, bonusBall));
                return new WinningLotto(lotto, bonusBall.number);
        }

        private boolean checkWinningLotto(Lotto lotto, BonusBall bonusBall) {
                if (lotto.hasBonusBall(bonusBall.number)) {
                        System.err.println("입력 값이 지난 주 당첨번호와 중복됩니다.");
                        return false;
                }
                return true;
        }
}
