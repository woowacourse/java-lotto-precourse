/*
 * LottoGenerator
 *
 * version 1.0
 *
 * 2019/04/10
 */

package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 번호를 발생시키는 클래스
 *
 * @author 김성훈
 * @version 1.0
 */
public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<Integer> setLottoNumber() {
        List<Integer> lotto = new ArrayList<>();
        while (lotto.size() < LOTTO_NUMBER_COUNT) {
            lotto.add(generateRandomNumber(lotto));
        }

        return lotto;
    }

    private int generateRandomNumber(List<Integer> list) {
        int randomNumber = -1;
        do {
            randomNumber = (int) (Math.random() * 45) + 1;
        } while (!checkIfDuplicateNumber(list, randomNumber));

        return randomNumber;
    }

    private boolean checkIfDuplicateNumber(List<Integer> list, int randomNumber) {
        return list.contains(randomNumber);
    }
}
