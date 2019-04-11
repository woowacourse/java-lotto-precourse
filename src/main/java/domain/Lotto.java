package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void addNumber(int number) {
        numbers.add(number);
    }

    public void create() {
        Set<Integer> set = new HashSet<>();

        while (set.size() < Const.CREATE_LOTTO_NUMBER_TIME) {
            set.add(createRandomNumber());
        }

        set.stream().forEach(r -> addNumber(r));
    }

    private int createRandomNumber() {
        return (int) (Math.random() * Const.MAX_LIMIT_LOTTO_NUMBER) + Const.MIN_LIMIT_LOTTO_NUMBER;
    }

    public boolean isOverlapToBonusNumber(String BonusNumber) {
        return numbers.contains(Integer.parseInt(BonusNumber));
    }

    public int matchNumber(Lotto winningLotto) {
        int countOfMatch = 0;

        for (int number : numbers) {
            countOfMatch += isContainWinningLotto(winningLotto, number);
        }
        return countOfMatch;
    }

    public int isContainWinningLotto(Lotto winningLotto, int userNumber) {
        if (winningLotto.getNumbers().contains(userNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

}
