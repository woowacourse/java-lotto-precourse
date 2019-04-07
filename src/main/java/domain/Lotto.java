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
        for (int i = 1; i <= LottoConstant.RANDOM_NUMBER_LIMIT; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);
        return numList.subList(0, LottoConstant.LOTTO_MAX_COUNT);
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

}
