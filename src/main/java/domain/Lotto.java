package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    static final int TOP = 45;
    static final int BOTTOM = 1;
    static final int COUNT_OF_LOTTO_NUMBERS = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현

    public boolean hasNumber(int number) {
        Set<Integer> set = new HashSet<>();
        set.addAll(numbers);
        set.add(number);

        return set.size() == COUNT_OF_LOTTO_NUMBERS;
    }
}
