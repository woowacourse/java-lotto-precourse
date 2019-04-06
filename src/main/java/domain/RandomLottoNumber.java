package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumber {
    private List<Integer> numbers = new ArrayList<>();

    public RandomLottoNumber() {
        for (int i = LottoGame.MIN_LOTTO_NUMBER; i <= LottoGame.MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
    }

    public void shuffle() {
        Collections.shuffle(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
