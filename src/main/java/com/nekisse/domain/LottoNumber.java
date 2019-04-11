package com.nekisse.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> basicLottoNumbers = new HashMap<>();

    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    static {
        IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER).
            forEach(number -> basicLottoNumbers.put(number, new LottoNumber(number)));
    }

    private final int  number;

    private LottoNumber(int number) {
        if (validNumber(number)) {
            throw new IllegalArgumentException("1~45의 숫자만 가능합니다.");
        }
        this.number = number;
    }

    private boolean validNumber(int number) {
        return number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER;
    }

    public static LottoNumber getBasicNumber(int number) {
        return Optional.ofNullable(basicLottoNumbers.get(number))
            .orElseThrow(() -> new IllegalArgumentException("1~45의 숫자만 가능합니다."));
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
