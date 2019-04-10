package domain;

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

    // 추가 기능 구현
}
