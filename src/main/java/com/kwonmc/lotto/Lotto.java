/*
 * @(#)Lotto.java
 *
 * v 0.0.0
 *
 * 2019.04.09
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */
package com.kwonmc.lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 *
 * @version 0.0.0
 * @author kwonmc
 * @author WoowahanTechCamp
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto lottoMaker() {
        ArrayList<Integer> lottoArray = new ArrayList<>();
        while (lottoArray.size() < Numbers.EACH_LOTTO_SIZE) {
            int random = (int) (Math.random() * Numbers.TOTAL_LOTTO_POOL) + 1;
            if (!lottoArray.contains(random)) {
                lottoArray.add(random);
            }
        }
        lottoArray.sort(null);
        return new Lotto(lottoArray);
    }

    public boolean contains(Integer number) {
        return (this.numbers.contains(number));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Integer> iterator = numbers.iterator();

        return stringMaker(stringBuilder, iterator);
    }

    private String stringMaker(StringBuilder stringBuilder, Iterator<Integer> iterator) {
        stringBuilder.append("[");
        while(iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (iterator.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
