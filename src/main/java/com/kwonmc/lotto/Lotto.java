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

    public static ArrayList<Integer> lottoMaker() {
        ArrayList<Integer> aLotto = new ArrayList<>();
        while (aLotto.size() < 6) {
            int random = (int) (Math.random() * 45) + 1;
            if (!aLotto.contains(random)) {
                aLotto.add(random);
            }
        }
        aLotto.sort(null);
        return aLotto;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Integer> iterator = numbers.iterator();
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
