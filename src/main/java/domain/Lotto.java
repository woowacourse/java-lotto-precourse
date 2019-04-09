package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final String DELIMITER = ",";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String toString() {
        return String.join(DELIMITER, String.valueOf(numbers));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
