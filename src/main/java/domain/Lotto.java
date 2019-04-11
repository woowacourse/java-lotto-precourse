package domain;

import java.util.HashSet;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR_MENT = "로또 번호는 중복되지 않는 6자리 숫자 입니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (checkDuplicate(numbers)) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MENT);
        }
        this.numbers = numbers;
    }

    private boolean checkDuplicate(List<Integer> numbers) {
        HashSet<Integer> duplicateCheckSet = new HashSet<>(numbers);
        return (duplicateCheckSet.size() != LOTTO_SIZE);
    }

    int countMatchedNumber(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(number -> otherLotto.numbers.contains(number))
                .count();
    }

    boolean hasBall(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers + "";
    }
}
