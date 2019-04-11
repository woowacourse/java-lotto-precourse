package domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final String NUMBER_COUNT_GUIDE = "당첨번호를 6개의 숫자로 다시 입력해주세요.";
    private static final String RANGE_GUIDE = "1 ~ 45 사이의 숫자로 당첨번호를 다시 입력해주세요.";
    private static final String DUPLICATE_GUIDE = "중복된 숫자가 있습니다.";
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

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

    public boolean isCorrectNumberCount() {
        return (this.numbers.size() == LOTTO_NUMBER_COUNT) ? true : false;
    }

    private boolean isBetweenLotteryRange(int number) {
        return ((number >= LOTTO_MIN_NUMBER) && (number <= LOTTO_MAX_NUMBER));
    }

    private boolean isNumbersBetweenLotteryRange() {
        List<Integer> numberInRange = this.numbers.stream()
            .filter(number -> isBetweenLotteryRange(number))
            .collect(Collectors.toList());
        return numberInRange.size() == LOTTO_NUMBER_COUNT;
    }

    private boolean haveDuplicates(List<Integer> numbers) {
        Set uniqueNumbers = new HashSet<Integer>(numbers);
        return uniqueNumbers.size() < numbers.size();
    }

    public boolean validateWinningNumbers() {
        if (!this.isCorrectNumberCount()) {
            System.out.println(NUMBER_COUNT_GUIDE);
            return false;
        }
        if (!this.isNumbersBetweenLotteryRange()) {
            System.out.println(RANGE_GUIDE);
            return false;
        }
        if (this.haveDuplicates(numbers)) {
            System.out.println(DUPLICATE_GUIDE);
            return false;
        }
        return true;
    }
}
