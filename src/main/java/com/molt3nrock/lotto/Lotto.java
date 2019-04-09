package com.molt3nrock.lotto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        List<String> numberStrings = numbers
            .stream()
            .map(Object::toString)
            .collect(Collectors.toList());
        return String.format("[%s]",String.join(", ", numberStrings));
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
