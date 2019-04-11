package domain;

import java.util.Iterator;
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

    /**
     * 로또가 특정한 번호를 포함하고 있는 지 검사하는 메소드
     */
    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    /**
     * 이 로또 번호를 다른 로또 번호와 비교하여 몇 개나 번호가 일치하는 지 확인하는 메소드
     * (두 집합의 교집합의 원소의 개수를 구하는 기능이므로, 교환법칙이 성립함)
     */
    public int match(Lotto anotherLotto) {
        int numberOfMatches = 0;
        Iterator<Integer> it = numbers.iterator();

        while(it.hasNext()) {
            numberOfMatches += (anotherLotto.contains(it.next())) ? 1 : 0;
        }

        return numberOfMatches;
    }
}
