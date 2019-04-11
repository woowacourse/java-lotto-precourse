package creator;

import object.BonusBall;
import object.Lotto;
import object.WinningLotto;

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
