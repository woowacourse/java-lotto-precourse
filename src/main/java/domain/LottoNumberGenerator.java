package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.LottoConst.LOTTO_MAX_NUMBER;
import static domain.LottoConst.LOTTO_MIN_NUMBER;
import static domain.LottoConst.LOTTO_NUMBER_COUNT;

public class LottoNumberGenerator {
    private final List<Integer> numbers;

    public LottoNumberGenerator() {
        numbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    List<Integer> makeLotto() {
        shuffleNumbers();
        return numbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }

    private void shuffleNumbers() {
        Collections.shuffle(numbers);
    }
}
