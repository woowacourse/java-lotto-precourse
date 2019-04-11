/*
 * Lotto Class
 *
 * @version 1.5
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.objects;

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
    public static final int NUMS_COUNT = 6;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }

    public int countMatch(Lotto otherLot) {
        int count = 0;

        for (int innerNum : numbers) {
            count += otherLot.contains(innerNum) ? 1 : 0;
        }
        return count;
    }


    @Override
    public String toString() {
        return "[" + numbers.stream().map(s -> String.valueOf(s)).collect(Collectors.joining(", ")) + "]";
    }
}
