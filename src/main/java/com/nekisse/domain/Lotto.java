package com.nekisse.domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
