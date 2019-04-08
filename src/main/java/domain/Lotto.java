package domain;

import java.util.List;
import java.util.Vector;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        printNumbers();
    }

    public void printNumbers() {
        final List<String> convertedNumbers = new Vector<>();

        for (Integer x : numbers) {
            convertedNumbers.add(String.valueOf(x));
        }
        System.out.println("[" + String.join(", ", convertedNumbers) + "]");
    }
}