package lotto;

import java.util.*;

import static constants.LottoConstants.*;

public class RandomNumber {
    public List<Integer> getNumbers() {
        HashSet<Integer> temp = new HashSet<>();

        while (temp.size() != COUNT_NUMBERS) {
            temp.add(new Random().nextInt(MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER);
        }

        List<Integer> numbers = new ArrayList<>(temp);
        Collections.sort(numbers);
        return numbers;
    }
}

