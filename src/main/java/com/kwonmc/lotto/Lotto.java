package com.kwonmc.lotto;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final int INT_ONE = 1;
    private static final int LOTTO_TOTAL_NUMBERS = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
}
