/**
 * 우아한테크코스 프리코스 3주차 미션
 * 로또 게임
 *
 * @author JiHoon Kim
 * @version 1.0
 */

package domain;

import java.util.List;
import java.util.StringJoiner;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void printNums() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        for (Integer i : numbers)
            joiner.add(String.valueOf(i));
        System.out.println(joiner.toString());
    }

    boolean contains(int number) {
        return numbers.contains(number);
    }

    List<Integer> getNumbersList() {
        return numbers;
    }
}
