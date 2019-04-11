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
    public void lotto_Number_Print() {
        System.out.print("[");
        for (int i = Info.ZERO; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            Comma(i);
        }
        System.out.print("]");
        System.out.println();
    }

    private void Comma(int i) {
        if (i < numbers.size() - 1) {
            System.out.print(", ");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
