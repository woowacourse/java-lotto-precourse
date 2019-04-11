package lotto;

import java.util.HashSet;
import java.util.List;

import static constants.LottoConstants.*;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkNumbersCount(numbers);
        checkOverlap(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    private void checkNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(COUNT_ERROR_MESSAGE);
        }
    }

    private void checkOverlap(List<Integer> numbers) {
        HashSet<Integer> temp = new HashSet<>(numbers);
        if (temp.size() != numbers.size()) {
            throw new IllegalArgumentException(SAME_NUMBER_ERROR_MESSAGE);
        }
    }
}
