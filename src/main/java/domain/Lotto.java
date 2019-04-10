package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }


    private void addNumber(int number) {
        numbers.add(number);
    }

    public void create() {
        Set<Integer> set = new HashSet<>();

        while (set.size() < Const.CREATE_LOTTO_NUMBER_TIME) {
            set.add(createRandomNumber());
        }

        set.stream().forEach(r -> addNumber(r));
    }
    
    public boolean isOverlapToBonusNumber(String BonusNumber) {
        return numbers.contains(Integer.parseInt(BonusNumber));
    }
}
