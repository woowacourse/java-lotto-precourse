package creator;

import object.BonusBall;
import object.Lotto;
import object.WinningLotto;

public class WinningLottoCreator implements Creator {
        @Override
        public WinningLotto create() {
                LastWeekWinningNumberCreator lastWeekWinningNumberCreator = new LastWeekWinningNumberCreator();
                BonusBallCreator bonusBallCreator = new BonusBallCreator();
                Lotto lotto = lastWeekWinningNumberCreator.create();
                BonusBall bonusBall = bonusBallCreator.create();
                WinningLotto winningLotto = new WinningLotto(lotto, bonusBall.number);
                return winningLotto;
        }
}
