package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
        private static final int SIZE = 6;
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
                this.numbers = numbers;
        }

        // 추가 기능 구현
        public static Lotto init() {
                HashSet hs = new HashSet();
                while (hs.size() < SIZE) {
                        hs.add(makeRandomNumber());
                }
                List lottoList = new ArrayList();
                lottoList.addAll(hs);
                return new Lotto(lottoList);
        }

        private static int makeRandomNumber() {
                Random random = new Random();
                return random.nextInt(45) + 1;
        }

        public void getNumbers() {
                System.out.println(numbers.toString());
        }
}
