package com.nekisse.domain;

import java.util.List;

import static com.nekisse.LottoRandomNumberGenerator.LIMIT_LOTTO_NUMBER;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if (validNumbersSize(numbers)) {
            throw new IllegalArgumentException("로또는 6자리 입니다.");
        }
        this.numbers = numbers;
    }

    public boolean isContainsNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private boolean validNumbersSize(List<LottoNumber> numbers) {
        return numbers.size() != LIMIT_LOTTO_NUMBER;
    }

    // 추가 기능 구현
    @Override
    public String toString() {
        return String.valueOf(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

}
