package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private static List<Integer> initializeCandidates() {
        List<Integer> candidates = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            candidates.add(i);
        }
        return candidates;
    }

    public static List<Integer> generateLottoNumbers() {
        List<Integer> candidates = initializeCandidates();
        Collections.shuffle(candidates);
        List<Integer> lottoNumbers = candidates.subList(0, LOTTO_NUMBER_COUNT);
        return lottoNumbers;
    }
}
