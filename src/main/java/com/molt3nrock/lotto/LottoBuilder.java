package com.molt3nrock.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoBuilder {

    private static final int MINIMUM_NUMBER_OF_LOTTO = 1;
    private static final int MAXIMUM_NUMBER_OF_LOTTO = 45;
    private static final int PRICE_PER_LOTTO = 1000;
    private static final int COUNT_OF_NUMBERS_PER_LOTTO = 6;

    private static List<Integer> generateNumbers() {
        ArrayList<Integer> integers = IntStream
            .range(MINIMUM_NUMBER_OF_LOTTO, MAXIMUM_NUMBER_OF_LOTTO + 1)
            .limit(COUNT_OF_NUMBERS_PER_LOTTO)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(integers);
        return integers;
    }
}
