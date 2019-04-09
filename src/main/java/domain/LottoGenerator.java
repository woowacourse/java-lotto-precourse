package domain;

import domain.interfaces.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private NumberGenerator generator;

    public LottoGenerator(NumberGenerator generator){
        this.generator = generator;
    }

    List<Integer> numbers;
    boolean[] isPicked;

    public Lotto generateLotto() {
        numbers = new ArrayList<>();
        isPicked = new boolean[generator.LOTTO_BOUND_SIZE];
        fillNumbers();
        return new Lotto(numbers);
    }

    private void fillNumbers() {
        while (numbers.size() != generator.LOTTO_LENGTH) {
            int num = generator.getNumber();
            checkIfPicked(num);
        }
    }

    private void checkIfPicked(int num) {
        if (!isPicked[num]) {
            numbers.add(num);
            isPicked[num] = true;
        }
    }

}
