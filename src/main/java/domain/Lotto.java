package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final int LOTTO_NUMBERS_COUNT= 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        assertLottoNumbersCount(numbers);
        this.numbers = numbers;
    }

    private void assertLottoNumbersCount(List<Integer> numbers) {
        if(numbers.size() < LOTTO_NUMBERS_COUNT)
            throw new IllegalArgumentException("번호가 부족합니다. 다시 입력해주세요");
        else if(numbers.size() > LOTTO_NUMBERS_COUNT)
            throw new IllegalArgumentException("번호를 많이 선택하셨습니다. 다시 입력해주세요");
    }
}
