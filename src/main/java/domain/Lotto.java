package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final int PRICE = 1000;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int PICK_NUM = 6;

    private final List<Integer> numbers;

    public static int howManyLotto(int money) {
        return money / PRICE;
    }

    public boolean contains(int n) {
        return numbers.contains(n);
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getMatchCount(Lotto userLotto) {
        int count = 0;
        for (int n : numbers) {
            count += userLotto.contains(n) ? 1 : 0;
        }
        return count;
    }
}
