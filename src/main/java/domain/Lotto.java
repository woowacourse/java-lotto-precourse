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
    
    /** 당첨 번호를 받아 일치하는 번호가 몇 개인지 반환 */
    public int getMatchCount(Lotto winningNumbers) {
        return (int) numbers.stream() // count()의 결과는 long이므로 주의
                .filter(i -> winningNumbers.hasNumber(i)).count();
    }
    
    /** 특정 숫자가 로또 안에 있는지 질의하는 메소드 */
    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }
}
