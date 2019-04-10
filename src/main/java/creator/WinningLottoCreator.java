package creator;

import domain.BonusBall;
import domain.Lotto;
import domain.LottoNumber;
import domain.WinningLotto;

public class WinningLottoCreator implements Creator {
        @Override
        public LottoNumber create() {
                LastWeekWinningNumberCreator lastWeekWinningNumberCreator = new LastWeekWinningNumberCreator();
                BonusBallCreator bonusBallCreator = new BonusBallCreator();
                Lotto lotto = lastWeekWinningNumberCreator.create();
                BonusBall bonusBall = bonusBallCreator.create();
                WinningLotto winningLotto = new WinningLotto(lotto, bonusBall.number);
                return winningLotto;
        }
}
