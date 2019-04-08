package com.codemcd.lotto;

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

    public int getCountOfMatch(Lotto winningLotto) {
        int countOfMatch = 0;
        for(int i = 0; i < numbers.size(); ++i) {
            countOfMatch += (winningLotto.isMatchedNumber(numbers.get(i)) == true) ? 1 : 0;
        }
        return countOfMatch;
    }

    public boolean isMatchedNumber(int currentLottoNumber) {
        return numbers.contains(currentLottoNumber);
    }

    public StringBuilder getLottoNumberWithComma() {
        StringBuilder numberWithComma = new StringBuilder();
        String delim = "";
        Iterator<Integer> it = numbers.iterator();
        while(it.hasNext()) {
            numberWithComma.append(delim).append(it.next());
            delim = ", ";
        }
        return numberWithComma;
    }
}
