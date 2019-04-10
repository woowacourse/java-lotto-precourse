package domain;

import java.util.Collections;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
    public List<Integer> getLottoNumber() {

        while (duplicateNumberCheck(numbers, createLottoNumber()).size() != LOTTO_SIZE) {
        }

        Collections.sort(numbers);
        System.out.println(printLottoNumber(numbers));

        return numbers;
    }

    private List<Integer> duplicateNumberCheck(List<Integer> numbers, int checkNumber) {
        if (!numbers.contains(checkNumber)) {
            numbers.add(checkNumber);
            return numbers;
        }
        return numbers;
    }

    private int createLottoNumber() {
        return ((int) (Math.random() * LOTTO_MAX_NUM) + LOTTO_MIN_NUM);
    }

    private String printLottoNumber(List<Integer> numbers) {
        return String.join(",", String.valueOf(numbers));
    }


}
