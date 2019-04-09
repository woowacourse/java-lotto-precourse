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

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void printNo() {
        for (int i = 0; i < 6; i++) {
            System.out.print(this.numbers.get(i));
            printComma(i);
        }
        System.out.println();
    }

    private void printComma(int i) {
        if (i < 5) {
            System.out.print(",");
        }
    }

}
