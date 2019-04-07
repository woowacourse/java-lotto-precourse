package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_LENGTH = 6;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int START_LOTTO_NUMBER = 1;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> makeLottoNumber(){

        Random makeLottoNumber = new Random();
        for(int i = 0; i<LOTTO_LENGTH; i++){

            this.numbers.add(makeLottoNumber.nextInt(END_LOTTO_NUMBER)+START_LOTTO_NUMBER);        // 로또 번호 생성
        }
        return numbers;
    }

    // 추가 기능 구현
}
