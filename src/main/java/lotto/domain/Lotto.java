package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    public final static int LOTTO_NUMBER_SIZE = 6;
    public final static int LOTTO_MIN_NUMBER = 1;
    public final static int LOTTO_MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public boolean isBonusNoDuplicate(int bonusNo) {
        if (numbers.contains(bonusNo))
            return true;
        return false;
    }

    public int calculateCountOfMatch(Lotto anotherLotto) {
        int countOfMatch = 0;
        for (int number : numbers)
            countOfMatch += anotherLotto.isDuplicate(number) ? 1 : 0;

        return countOfMatch;
    }

    public boolean isDuplicate(int number) {
        return numbers.contains(number);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_SIZE + "개만 가능합니다.");
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers)
            validateRange(number);
    }

    private void validateRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_MIN_NUMBER + "~" + LOTTO_MAX_NUMBER + "만 입력 가능합니다.");
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException("로또 번호들 중복이 불가능합니다.");
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
