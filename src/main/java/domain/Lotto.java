package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final int ONE = 1;
    private static final int ZERO = 0;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    protected void printLottoNumbers() {
        System.out.println(numbers.toString());
    }

    protected int getCountOfMatch(Lotto winningLotto) {
        int countOfMatch = 0;

        for (int number : numbers) {
            countOfMatch += winningLotto.hasNumber(number) ? ONE : ZERO;
        }

        return countOfMatch;
    }

    private boolean hasNumber(int numberToCompare) {
        return numbers.contains(numberToCompare);
    }
}
