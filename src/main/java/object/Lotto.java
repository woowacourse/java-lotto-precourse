/*
 *@(#)Lotto.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package object;

import java.util.List;

/**
 * 로또 게임에서 로또 하나를 나타내는 클래스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
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

        public int requestCountMatchNumber(Lotto otherLotto) {
                return otherLotto.countMatchNumber(this.numbers);
        }

        public boolean hasBonusBall(int bonusBall) {
                return this.numbers.contains(bonusBall);
        }

        private int countMatchNumber(List<Integer> otherLottoNumbers) {
                int matchCount = 0;
                for (int otherNumber : otherLottoNumbers) {
                        matchCount += this.numbers.contains(otherNumber) ? 1 : 0;
                }
                return matchCount;
        }
}
