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

        public int requestCountMatchNumber(Lotto otherLotto){
                return otherLotto.countMatchNumber(this.numbers);
        }

        private int countMatchNumber(List<Integer> otherLottoNumbers){
                int matchCount=0;
                for(int otherNumber : otherLottoNumbers){
                        matchCount += this.numbers.contains(otherNumber) ? 1 : 0 ;
                }
                return matchCount;
        }
}
