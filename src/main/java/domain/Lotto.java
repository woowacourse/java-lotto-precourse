package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> numList = new ArrayList<>();
        for (int i = LottoConstant.RANDOM_NUMBER_LOWER_LIMIT; i <= LottoConstant.RANDOM_NUMBER_UPPER_LIMIT; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);
        return numList.subList(0, LottoConstant.LOTTO_MAX_COUNT);
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    public int isContainNumber(Lotto winningLotto, int index) {
        return (numbers.contains(winningLotto.getLotto().get(index))) ? 1 : 0;
    }

    public boolean isContainBonus(int bonusNum) {
        return (numbers.contains(bonusNum));
    }
}
