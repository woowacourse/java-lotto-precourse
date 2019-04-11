package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoManager {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO_NUMBER = 6;

    public Lotto generateLotto() {
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i< NUMBER_OF_LOTTO_NUMBER; i++) {
            sequence.add(getUniqueRandomInt(sequence));
        }
        Collections.sort(sequence);
        return new Lotto(sequence);
    }

    private Integer getUniqueRandomInt(List<Integer> sequence) {
        int randomInt;
        do {
            randomInt = getRandomInt();
        } while (sequence.contains(randomInt));
        return randomInt;
    }

    private int getRandomInt() {
        Random random = new Random();
        return (random.nextInt(MAX_LOTTO_NUMBER + 1 - MIN_LOTTO_NUMBER) + MIN_LOTTO_NUMBER);
    }
}
