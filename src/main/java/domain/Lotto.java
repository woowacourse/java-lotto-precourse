package domain;

import exception.DuplicatedLottoNumberException;
import exception.LottoBallCountException;
import exception.LottoNumberException;
import exception.MoneyInputException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final int PRICE = 1000;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int PICK_NUM = 6;

    private final List<Integer> numbers;

    public static int howManyLotto(int money) throws IllegalArgumentException {
        if (money >= PRICE && money < Integer.MAX_VALUE) {
            return money / PRICE;
        }

        throw new MoneyInputException();
    }

    public boolean contains(int n) {
        return numbers.contains(n);
    }

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        checkArgument(numbers);
        this.numbers = numbers;
    }

    private void checkArgument(List<Integer> numbers) throws IllegalArgumentException {
        checkBallCount(numbers.size());
        checkBallNumbers(numbers);
    }

    private void checkBallCount(int n) {
        if (n != PICK_NUM) { // 공의 수 검사
            throw new LottoBallCountException();
        }
    }

    private void checkBallNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int n : numbers) { // 중복과 범위 검사
            set.add(n);
            isInBound(n);
        }

        if (set.size() != PICK_NUM) {
            throw new DuplicatedLottoNumberException();
        }
    }

    private void isInBound(int n) throws IllegalArgumentException {
        if (n > MAX_NUM || n < MIN_NUM) {
            throw new LottoNumberException();
        }
    }

    public int getMatchCount(Lotto userLotto) {
        int count = 0;
        for (int n : numbers) {
            count += userLotto.contains(n) ? 1 : 0;
        }
        return count;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
