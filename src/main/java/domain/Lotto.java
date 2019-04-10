package domain;

import java.util.List;
import java.util.Vector;
import java.util.HashSet;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) { this.numbers = numbers; }

    public Lotto printNumbers() {
        final List<String> convertedNumbers = new Vector<>();

        for (Integer x : numbers) {
            convertedNumbers.add(String.valueOf(x));
        }
        System.out.println("[" + String.join(", ", convertedNumbers) + "]");
        return this;
    }

    public HashSet<Integer> unionSet(Lotto rhs) {
        final List<Integer> appendedList = new Vector<>(numbers);

        appendedList.addAll(rhs.numbers);
        return new HashSet<>(appendedList);
    }

    public boolean contains(final int x) {
        return numbers.contains(x);
    }
}