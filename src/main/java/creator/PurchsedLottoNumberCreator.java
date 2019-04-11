/*
 *@(#)PurchasedLottoNumberCreator.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package creator;

import object.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 로또게임의 사용자가 구매한 하나의 로또를 생성하는 클래스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
 */

public class PurchsedLottoNumberCreator implements Creator {
        @Override
        public Lotto create() {
                List<Integer> numbers = new ArrayList<Integer>();
                Random random = new Random();
                while (numbers.size() < numberOfLotto) {
                        addOneNumberWithoutDuplication(numbers, random.nextInt(maxLottoNumber) + 1);
                }
                Lotto lotto = new Lotto(numbers);
                return lotto;
        }

        private void addOneNumberWithoutDuplication(List<Integer> numbers, int number) {
                if (!numbers.contains(number)) {
                        numbers.add(number);
                }
        }
}
