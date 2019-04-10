package domain;

import java.util.List;
import java.util.Collections;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        setSort();
        return numbers;
    }

    public void setSort() {
        Collections.sort(numbers);
    }
}