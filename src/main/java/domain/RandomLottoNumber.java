package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RandomLottoNumber {
    private List<Integer> numbers = new ArrayList<>();

    RandomLottoNumber() {
        for (int i = LottoGame.MIN_LOTTO_NUMBER; i <= LottoGame.MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
    }

    void shuffle() {
        Collections.shuffle(numbers);
    }

    List<Integer> getNumbers() {
        return numbers;
    }
}
