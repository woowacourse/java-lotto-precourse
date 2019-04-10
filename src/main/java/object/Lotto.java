package object;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto implements LottoNumber {
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
                this.numbers = numbers;
        }

        public void printNumbers() {
                String numbers = this.numbers.toString();
                System.out.println(numbers);
        }

        public List<Integer> getNumbers(){
                return this.numbers;
        }

        @Override
        public boolean equals(Object obj){
                Lotto lotto = (Lotto)obj;
                return this.numbers.equals(lotto.getNumbers());
        }
}
