package domain;

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

    public List<Integer> getNumbers() { return this.numbers; }

    public boolean hasNumber(int num) { return this.numbers.contains(num); }

    public String toString() {
        Collections.sort(this.numbers);
        return this.numbers.toString();
    }
}
