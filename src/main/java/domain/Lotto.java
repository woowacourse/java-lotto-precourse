package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto implements  LottoNumber{
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
                this.numbers = numbers;
        }

        public void printNumbers() {
                String numbers = this.numbers.toString();
                System.out.println(numbers);
        }
}
