package com.molt3nrock.lotto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {

    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        List<String> numberStrings = numbers
            .stream()
            .sorted()
            .map(Object::toString)
            .collect(Collectors.toList());
        return String.format("[%s]", String.join(", ", numberStrings));
    }

    List<Integer> getNumbers() {
        return this.numbers;
    }
}
