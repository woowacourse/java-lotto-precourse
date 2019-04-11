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

    // 추가 기능 구현
    public void print() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < 6; i++)
            sb.append(numbers.get(i) +", ");
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        System.out.println(sb.toString());
    }
}
