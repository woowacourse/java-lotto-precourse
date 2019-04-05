package domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int n) {
        return numbers.contains(n);
    }

    public int countMatch(Lotto other) {
        int cnt = 0;
        for (int i : numbers) {
            cnt += other.contains(i) ? 1 : 0;
        }

        return cnt;
    }

    @Override
    public String toString() {
        // List가 Integer 타입이기 때문에 String.join() 메서드 사용하려면 타입 변환해야 함.
        return "[ " +
            numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")) +
            " ]";
    }
}
