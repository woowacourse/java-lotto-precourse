package domain;

import java.util.List;

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

    // 추가 기능 구현
}
