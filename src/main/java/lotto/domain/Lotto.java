package lotto.domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    public final static int LOTTO_NUMBER_SIZE = 6;
    public final static int LOTTO_MIN_NUMBER = 1;
    public final static int LOTTO_MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
}
