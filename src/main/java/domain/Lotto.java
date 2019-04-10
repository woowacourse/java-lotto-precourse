package domain;

import java.util.HashSet;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int MAX_LOTTO_NUM = 45;
    public static final int MIN_LOTTO_NUM = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static boolean duplicateNumberInLotto(List<Integer> numbers) {
        HashSet<Integer> recordLotto = new HashSet<>();
        for (Integer number : numbers) {
            recordLotto.add(number);
        }
        return (recordLotto.size() != Lotto.LOTTO_NUMBER_SIZE);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
