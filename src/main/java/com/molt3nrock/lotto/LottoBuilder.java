package com.molt3nrock.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoBuilder implements MoneyLottoBuilder, FinalLottoBuilder {

    private static final int MINIMUM_NUMBER_OF_LOTTO = 1;
    private static final int MAXIMUM_NUMBER_OF_LOTTO = 45;
    private static final int PRICE_PER_LOTTO = 1000;
    private static final int COUNT_OF_NUMBERS_PER_LOTTO = 6;
    private int money = 0;

    static MoneyLottoBuilder create() {
        return new LottoBuilder();
    }

    @Override
    public FinalLottoBuilder withMoney(int money) {
        if (money >= PRICE_PER_LOTTO) {
            this.money = money;
            return this;
        }
        throw new IllegalArgumentException("로또를 구입하기에 돈이 충분하지 않습니다.");
    }

    @Override
    public List<Lotto> build() {
        return IntStream
            .range(0, money / PRICE_PER_LOTTO)
            .mapToObj(i -> new Lotto(generateNumbers()))
            .collect(Collectors.toList());
    }

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

interface MoneyLottoBuilder {

    FinalLottoBuilder withMoney(int money);
}

interface FinalLottoBuilder {

    List<Lotto> build();
}
