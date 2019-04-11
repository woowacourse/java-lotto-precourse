package woowacourse.lotto.util;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    void printLotto() {
        System.out.println(numbers.toString());
    }

    boolean hasNumber(int num) {
        return numbers.contains(num);
    }

    int countMatch(Lotto lotto) {
        int countOfMatch = 0;
        for (int num : numbers) {
            countOfMatch += lotto.hasNumber(num) ? 1 : 0;
        }
        return countOfMatch;
    }
}
