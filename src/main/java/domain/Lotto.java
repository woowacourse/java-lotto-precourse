package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        System.out.print("[");
        for (int i = 0; i < this.numbers.size(); i++) {
            System.out.print(this.numbers.get(i) + printComma(i));
        }
        System.out.println("]");
    }

    private String printComma(int i) {
        if (i != 5) {
            return ", ";
        }
        return "";
    }
}
