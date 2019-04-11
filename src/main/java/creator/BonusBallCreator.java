/*
 *@(#)BonusBallCreator.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package creator;

import object.BonusBall;
import util.InputUtil;
import util.PrintUtil;

/**
 * 보너스 볼 번호를 생성하는 클래스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
 */

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
