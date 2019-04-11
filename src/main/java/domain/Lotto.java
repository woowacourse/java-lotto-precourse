package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final int LOTTO_NUMBERS_COUNT= 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        assertLottoNumbersCount(numbers);
        assertDuplicateLotto(numbers);
        assertLottoNumber(numbers);
        this.numbers = numbers;
    }

    private void assertLottoNumbersCount(List<Integer> numbers) {
        if(numbers.size() < LOTTO_NUMBERS_COUNT)
            throw new IllegalArgumentException("번호가 부족합니다. 다시 입력해주세요");
        else if(numbers.size() > LOTTO_NUMBERS_COUNT)
            throw new IllegalArgumentException("번호를 많이 선택하셨습니다. 다시 입력해주세요");
    }

    private void assertDuplicateLotto(List<Integer> numbers) {
        List<Integer> checknumbers = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++) {
            if(checknumbers.contains(numbers.get(i)))
                throw new IllegalArgumentException("번호가 중복되었습니다.");
            checknumbers.add(numbers.get(i));
        }
    }

    private void assertLottoNumber(List<Integer> numbers) {
        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > LOTTO_MAX_NUMBER)
                throw new IllegalArgumentException("45보다 큰 수를 입력하셨습니다.");
            else if(numbers.get(i) < LOTTO_MIN_NUMBER)
                throw new IllegalArgumentException("1보다 작은 수를 입력하셨습니다.");
        }
    }

}
