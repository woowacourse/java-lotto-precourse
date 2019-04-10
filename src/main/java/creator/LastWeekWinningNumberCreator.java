package creator;

import domain.Lotto;
import domain.LottoNumber;
import util.InputUtil;
import util.PrintUtil;

public class LastWeekWinningNumberCreator implements Creator{
        @Override
        public LottoNumber create() {
                PrintUtil.printLastWeekWinningNumberInputMessage();
                Lotto lotto = new Lotto(InputUtil.inputLastWeekWinningNumber());
                return lotto;
        }
}
