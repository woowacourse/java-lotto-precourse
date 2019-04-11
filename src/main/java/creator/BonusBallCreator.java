package creator;

import object.BonusBall;
import util.InputUtil;
import util.PrintUtil;

public class BonusBallCreator implements Creator {

        private static final int inputFormatError = -999_999_999;

        @Override
        public BonusBall create() {
                int bonusNo;
                do {
                        PrintUtil.printBonusBallInputMessage();
                        bonusNo = InputUtil.inputBonusBall();
                } while (bonusNo == inputFormatError || !checkBonusBall1to45(bonusNo));
                BonusBall bonusBall = new BonusBall(bonusNo);
                return bonusBall;
        }

        private boolean checkBonusBall1to45(int bonusNo) {
                if (bonusNo < 1 || bonusNo > 45) {
                        System.err.println("1~45범위 밖 숫자 입력 오류");
                        return false;
                }
                return true;
        }
}
