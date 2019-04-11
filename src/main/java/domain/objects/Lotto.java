/*
 * Lotto Class
 *
 * @version 2
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
    public static final int UNIT_PRICE = 1000;
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;
    public static final int NUMS_COUNT = 6;

    private final List<Integer> numbList;

    public Lotto(List<Integer> numList) {
        this.numbList = numList;
    }

    public boolean contains(int num) {
        return numbList.contains(num);
    }

    public int countMatch(Lotto externalLot) {
        int matchCount = 0;

        for (int innerNum : numbList) {
            matchCount += externalLot.contains(innerNum) ? 1 : 0;
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return "[" + numbList.stream().map(s -> String.valueOf(s)).collect(Collectors.joining(", ")) + "]";
    }
}
