package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int countMatchingLottoNum(Lotto lotto) {
        return (int) numbers.stream()
                .filter((num) -> lotto.doesLottoContainsNum(num))
                .count();
    }

    boolean doesLottoContainsNum(int num) {
        return numbers.contains(new Integer(num));
    }
}
