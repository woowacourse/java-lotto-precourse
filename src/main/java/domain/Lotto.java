package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    String getLottoNumberString() {
        return numbers.toString();
    }

    int getCountOfMatch(Lotto winningLotto) {
        return Math.toIntExact(numbers.stream().filter(winningLotto.numbers::contains).count());
    }

    boolean hasNumber(int numberToCompare) {
        return numbers.contains(numberToCompare);
    }
}
