package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {
    private static final List<Integer> numbers = new ArrayList<>();
    private final static int sizeOfNumber = 45;
    private final static int sizeOfLotto = 6;

    private PickingNumbers() {

    }

    public static void fill() {
        for (int i = 0; i < sizeOfNumber; i++) {
            numbers.add(i + 1);
        }
    }

    public static void shuffle() {
        Collections.shuffle(numbers);
    }

    public static List<Integer> getSix() {
        return numbers.subList(0, sizeOfLotto);
    }
}
