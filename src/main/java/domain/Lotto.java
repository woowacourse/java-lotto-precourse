package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    public static int LOTTO_NUM_CNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean isContainNumber(int x) {
        return numbers.contains(x);
    }

    public int getEleNumber(int idx) {
        return numbers.get(idx);
    }

    public void numbersPrint() {
        System.out.print("[");
        for (int i = 0; i < numbers.size() - 1; ++i) {
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.print(numbers.get(numbers.size() - 1) + "]");
    }
}
