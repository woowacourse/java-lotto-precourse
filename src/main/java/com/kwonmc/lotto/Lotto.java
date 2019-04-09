package com.kwonmc.lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
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
        while (lottoArray.size() < 6) {
            int random = (int) (Math.random() * 45) + 1;
            if (!lottoArray.contains(random)) {
                lottoArray.add(random);
            }
        }
        lottoArray.sort(null);
        return new Lotto(lottoArray);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Integer> iterator = numbers.iterator();

        return stringBuilderHelper(stringBuilder, iterator).toString();
    }

    private StringBuilder stringBuilderHelper(StringBuilder stringBuilder, Iterator<Integer> iterator) {
        stringBuilder.append("[");
        while(iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (iterator.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder;
    }
}
