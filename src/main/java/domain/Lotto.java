/*
 * Lotto Class
 *
 * @version 1.3
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;
    public static final int UNIT_PRICE = 1000;
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int num){
        return numbers.contains(num);
    }

    @Override
    public String toString() {
        return "[" +numbers.stream().map(s->String.valueOf(s)).collect(Collectors.joining(", ")) + "]";
    }
}
