package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현

    /**
     * 로또 번호를 출력하기 위해 Lotto 클래스의 조상 클래스인 Object 클래스의 toString 메소드를 오버라이드 함
     */
    public String toString() {
        return numbers.toString();
    }
}
