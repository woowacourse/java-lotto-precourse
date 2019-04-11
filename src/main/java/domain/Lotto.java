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

    public int getCountOfMatch(Lotto targetLotto) {
        int countOfMatch = (int) targetLotto.getNumbers().stream().
                filter(num -> this.isContainNumber(num)).count();
        return countOfMatch;
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }
}
