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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int isMatch(int number) {
        if (numbers.contains(number)) {
            return 1;
        }

        return 0;
    }

    public int howManyMatch(Lotto lotto) {
        int countOfMatch = 0;

        for (int number : numbers) {
            countOfMatch += lotto.isMatch(number);
        }

        return countOfMatch;
    }
}
