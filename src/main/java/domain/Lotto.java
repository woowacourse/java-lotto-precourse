package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    List<Integer> getNumbers() {
        return this.numbers;
    }

    void printLottoNumbers() {
        List<String> stringList = new ArrayList<>();

        for (int number : numbers) {
            stringList.add(Integer.toString(number));
        }
        String result = String.join(", ", stringList);
        System.out.println("[" + result + "]");
    }
}
