package domain;

import domain.interfaces.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private NumberGenerator numberGenerator;
    List<Integer> numbers;
    boolean[] isPicked;

    public LottoGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto generateLotto() {
        numbers = new ArrayList<>();
        isPicked = new boolean[numberGenerator.LOTTO_BOUND_SIZE];
        fillNumbers();
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private void fillNumbers() {
        while (numbers.size() != numberGenerator.LOTTO_LENGTH) {
            int num = numberGenerator.getNumber();
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
