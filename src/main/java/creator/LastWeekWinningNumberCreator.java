/*
 *@(#)LastWeekWinningNumberCreator.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package creator;

import object.Lotto;
import util.InputUtil;
import util.PrintUtil;

import java.util.List;

/**
 * 지난 주 당첨 로또 번호를 생성하는 클래스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
 */

public class LastWeekWinningNumberCreator implements Creator {
        @Override
        public Lotto create() {
                List<Integer> numbers = null;
                do {
                        PrintUtil.printLastWeekWinningNumberInputMessage();
                        numbers = InputUtil.inputLastWeekWinningNumber();
                } while (numbers == null);
                Lotto lotto = new Lotto(numbers);
                return lotto;
        }
}
