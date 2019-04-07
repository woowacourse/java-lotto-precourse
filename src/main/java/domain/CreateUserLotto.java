package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class CreateUserLotto {
    private static final int NUM_OF_LOTTO = 6;

    static void  createLotto(int count) {
        Lotto[] lottos = new Lotto[count];

        for(int i = 0; i < count; i++) {
            lottos[i] = new Lotto(createRandom());
            lottos[i].getLotto();
        }
    }

    static List<Integer> createRandom() {
        List<Integer> numbers = new ArrayList<Integer>();
        Random random = new Random();

        while (numbers.size() < NUM_OF_LOTTO) {
            numbers = checkNumber(numbers);
            numbers.add(random.nextInt(44) + 1);
        }

        return numbers;
    }

    static List<Integer> checkNumber(List<Integer> numbers) {
        HashSet hs = new HashSet();
        hs.addAll(numbers);
        numbers.clear();
        numbers.addAll(hs);


        return numbers;
    }
}
