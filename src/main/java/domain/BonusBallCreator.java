package domain;

import util.InputUtil;
import util.PrintUtil;

public class BonusBallCreator implements Creator {
        @Override
        public BonusBall create() {
                PrintUtil.printBonusBallInputMessage();
                BonusBall bonusBall = new BonusBall(InputUtil.inputBonusBall());
                return bonusBall;
        }
}
