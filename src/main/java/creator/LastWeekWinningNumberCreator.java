package creator;

import object.Lotto;
import util.InputUtil;
import util.PrintUtil;

public class LastWeekWinningNumberCreator implements Creator {
        @Override
        public Lotto create() {
                PrintUtil.printLastWeekWinningNumberInputMessage();
                Lotto lotto = new Lotto(InputUtil.inputLastWeekWinningNumber());
                return lotto;
        }
}
