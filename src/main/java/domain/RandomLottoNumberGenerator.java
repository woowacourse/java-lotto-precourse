package domain;

import domain.interfaces.LottoNumberGenerator;

import java.util.*;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public Set<Integer> generateLottoNumberSet() {
        SortedSet<Integer> generatedNumSet = new TreeSet<>();

        while (!isNumberSetFull(generatedNumSet)) {
            generatedNumSet.add(generateLottoNumber());
        }

        return generatedNumSet;
    }

    private boolean isNumberSetFull(Set<Integer> numbers) {
        return numbers.size() == LOTTO_NUMS_LENGTH;
    }

    private int generateLottoNumber() {
        return new Random().nextInt(LOTTO_NUM_MIN + LOTTO_NUM_MAX - 1) + LOTTO_NUM_MIN;
    }
}
