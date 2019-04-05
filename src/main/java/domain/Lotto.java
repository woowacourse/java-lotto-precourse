package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;
    private final static int RANDOM_NUMBER_RANGE = 45;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> numList = new ArrayList<>();
        int number;

        while (numList.size() < 6) {
            number = generateRandomNumber();
            if (!numList.contains(number)) {
                numList.add(number);
            }
        }

        return numList;
    }

    private static int generateRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_RANGE) + 1;
    }

    String getLotto() {
        return numbers.toString();
    }
}
