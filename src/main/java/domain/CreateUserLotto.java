package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import static domain.InfoString.*;

public class CreateUserLotto {
    static Lotto[] lottos = null;

    static void  createLotto(int count) {
        lottos = new Lotto[count];

        for(int i = 0; i < count; i++) {
            lottos[i] = new Lotto(createRandom());
            lottos[i].getLotto();
        }
    }

    static List<Integer> createRandom() {
        List<Integer> numbers = new ArrayList<Integer>();
        Random random = new Random();

        while(numbers.size() != NUM_OF_LOTTO) {
            numbers = checkNumber(numbers);
            numbers.add(random.nextInt(MAX_OF_NUM) + 1);
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
