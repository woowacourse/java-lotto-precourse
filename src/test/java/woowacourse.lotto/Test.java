/*
 * Test.java
 * version 1.0
 * 2019.04.11
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package woowacourse.lotto;

import woowacourse.lotto.util.RandomGeneratorTest;
import woowacourse.lotto.util.StatsCalculationTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test class is a test sheet user writes manually.
 * Two kinds of test are available.
 */
public class Test {
    public static void main(String[] args) {

        /* Test if random number is generated correctly. */
        testRandomGenerator();

        /* Test if final result is printed correctly. */
        testStatsCalculation();
    }

    private static void testRandomGenerator() {
        RandomGeneratorTest randomGeneratorTest = new RandomGeneratorTest();
        for (int i = 0; i < 100; i++) {
            randomGeneratorTest.test(new String[]{});
        }
        randomGeneratorTest.printResult();
    }

    private static void testStatsCalculation() {
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printstream = new PrintStream(baos);
        System.setOut(printstream);
        StatsCalculationTest statsCalculationTest = new StatsCalculationTest();
        statsCalculationTest.test(new String[]{"0,0,0,0,0", "3000", "0.000"});
        statsCalculationTest.test(new String[]{"1,0,0,0,0", "3000", "1.667"});
        statsCalculationTest.test(new String[]{"0,1,0,0,0", "50000", "1.000"});
        statsCalculationTest.test(new String[]{"0,0,1,0,0", "8000", "187.500"});
        statsCalculationTest.test(new String[]{"0,0,0,1,0", "48000", "625.000"});
        statsCalculationTest.test(new String[]{"0,0,0,0,1", "3000", "666666.667"});
        statsCalculationTest.test(new String[]{"0,0,0,0,100", "2000000000", "100.000"});
        System.setOut(original);
        statsCalculationTest.printResult();
    }
}
