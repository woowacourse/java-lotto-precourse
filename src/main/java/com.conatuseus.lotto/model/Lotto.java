/*
 *  @(#)Lotto.java       3.00    2019/04/10
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 *  conatuseus@gmail.com
 */

package com.conatuseus.lotto.model;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 *
 *
 * author 사명기
 * @version 3.00    2019년 4월 10일
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    public boolean isContain(int number) {
        return this.numbers.contains(number);
    }
}
