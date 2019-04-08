package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;
    private final static int LOTTO_NUMBER_COUNT = 6;
    private List<Integer> numbers;

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
