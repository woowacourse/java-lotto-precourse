package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String toString() {
        return String.join(",", numbers.toString());
    }

    public int countOfMatch(Lotto lotto) {
        int count = 0;
        for (int num : numbers) {
            count += lotto.contains(num) ? 1 : 0;
        }
        return count;
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }
}