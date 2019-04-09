package domain;

import java.util.List;
import java.util.stream.Collectors;

import static domain.LottoConst.*;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateDuplication(numbers);
        validateSize(numbers);
        validateRange(numbers);

        this.numbers = numbers;
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> duplicationRemovedNumbers =
                numbers.stream()
                        .distinct()
                        .collect(Collectors.toList());

        if (!duplicationRemovedNumbers.equals(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호 개수가 유효하지 않습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        long validRangeNumberCount = numbers.stream()
                .filter(number -> number >= LOTTO_MIN_NUMBER)
                .filter(number -> number <= LOTTO_MAX_NUMBER)
                .count();

        if (validRangeNumberCount != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("유효하지 않은 로또 번호가 있습니다.");
        }
    }

    int getCountOfMatchedNumber(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }

    boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
