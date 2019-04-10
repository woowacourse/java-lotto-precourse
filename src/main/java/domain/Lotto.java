package domain;

import java.util.HashSet;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int countMatchedNumber(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(number -> otherLotto.numbers.contains(number))
                .count();
    }

    boolean hasBall(int number) {
        return numbers.contains(number);
    }
}
