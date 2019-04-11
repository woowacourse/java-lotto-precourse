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

    public List<Integer> getNumbersList() {
        return numbers;
    }

    public int getBonusNumber(){
        return numbers.get(Controller.LOTTOS_NUMBER -1);
    }
}
