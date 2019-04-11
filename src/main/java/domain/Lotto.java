package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 로또 한장을 의미하는 객체
 */

/*
 기본 생성자 추가 x
 numbers 변수의 접근 제어자인 private을 변경할 수 없다.
 Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printLotto() {
        String result = numbers.stream().map(Objects::toString)
                .collect(Collectors.joining(", "));
        System.out.println("[" + result + "]");
    }
}
