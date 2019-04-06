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

    public List<Integer> getLottoNumber() {
        return this.numbers;
    }

    public String printLottoNumber(){
        return this.numbers.toString();
    }
}
