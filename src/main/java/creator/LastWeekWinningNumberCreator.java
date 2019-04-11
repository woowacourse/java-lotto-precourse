package creator;

import object.Lotto;
import util.InputUtil;
import util.PrintUtil;

import java.util.List;

public class LastWeekWinningNumberCreator implements Creator {
        @Override
        public Lotto create() {
                List<Integer> numbers=null;
                do{
                        PrintUtil.printLastWeekWinningNumberInputMessage();
                        InputUtil.inputLastWeekWinningNumber();
                }while(numbers==null);
                Lotto lotto = new Lotto(numbers);
                return lotto;
        }
}
