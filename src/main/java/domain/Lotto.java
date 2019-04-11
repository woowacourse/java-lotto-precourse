package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getCountOfMatch(Lotto winningLotto) {
        int count = 0;
        for (int number : numbers)
            count += winningLotto.contains(number) ? 1 : 0;

        return count;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public void print() {
        StringBuilder sb = new StringBuilder("[");
        for (int number: numbers)
            sb.append(number +", ");
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        System.out.println(sb.toString());
    }
}
