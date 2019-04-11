/*
 * RandomGeneratorTest.java
 * version 1.0
 * 2019.04.11
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package woowacourse.lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGeneratorTest extends DefaultTest {
    @Override
    public void test(String[] args) {
        Random rand = new Random();
        List<Integer> numbers = UserLottoSet.generateLotto(rand).getNumbers();
        if (checkNumbers(numbers)) {
            correctAnswer++;
        }
        testCount++;
    }

    private boolean checkNumbers(List<Integer> numbers) {
        List<Integer> seenNumbers = new ArrayList<>();
        for (int n : numbers) {
            if (n < LottoShop.NUMBER_LOWER_BOUND
                    || n > LottoShop.NUMBER_UPPER_BOUND) {
                return false;
            }
            if (seenNumbers.contains(n)) {
                return false;
            }
            seenNumbers.add(n);
        }
        return true;
    }
}
