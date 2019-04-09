package com.molt3nrock.lotto;

import static com.molt3nrock.lotto.Constants.COUNT_OF_NUMBERS_PER_LOTTO;
import static com.molt3nrock.lotto.Constants.MAXIMUM_NUMBER_OF_LOTTO;
import static com.molt3nrock.lotto.Constants.MINIMUM_NUMBER_OF_LOTTO;
import static com.molt3nrock.lotto.Constants.PRICE_PER_LOTTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 사용자가 구입한 로또 리스트를 생성하기위한 클래스
 */
class LottoBuilder implements MoneyLottoBuilder, FinalLottoBuilder {

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
        return Stream.generate(() -> new Lotto(generateNumbers()))
            .limit(money / PRICE_PER_LOTTO)
            .collect(Collectors.toList());
    }

    private static List<Integer> generateNumbers() {
        ArrayList<Integer> integers = IntStream
            .range(MINIMUM_NUMBER_OF_LOTTO, MAXIMUM_NUMBER_OF_LOTTO + 1)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(integers);
        return integers.stream().limit(COUNT_OF_NUMBERS_PER_LOTTO).collect(Collectors.toList());
    }
}

/**
 * {@code LotteBuilder} 의 {@code money} 값의 지정을 강제하기 위한 인터페이스.
 *
 * LotteBuilder 의 withMoney() 를 호출 한 이후에만 build()를 사용 할 수 있도록
 * {@code MoneyLottoBuilder}와 {@code FinalLottoBuilder}를 이용하여 build() 메쏘드의 접근을 제어 합니다.
 */
interface MoneyLottoBuilder {

    FinalLottoBuilder withMoney(int money);
}

/**
 * {@code LotteBuilder} 의 {@code build()} 메쏘드 접근 제어를 위한 인터페이스.
 *
 * LotteBuilder 의 withMoney() 를 호출 한 이후에만 build()를 사용 할 수 있도록
 * {@code MoneyLottoBuilder}와 {@code FinalLottoBuilder}를 이용하여 build() 메쏘드의 접근을 제어 합니다.
 */
interface FinalLottoBuilder {

    List<Lotto> build();
}
