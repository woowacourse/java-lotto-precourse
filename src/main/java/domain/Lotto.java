/*
 * Lotto
 *
 * version 1.1
 *
 * 2019/04/10
 */

package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 *
 * @author 우아한 테크코스, 김성훈
 * @version 1.0 2019/04/10  로또 숫자 출력 메소드 구현
 *          1.1 2019/04/11  다른 로또 번호(당첨 번호)와 일치 갯수 계산 메소드 구현
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void printLottoNumbers() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int number : numbers) {
            stringBuilder.append(number);
            stringBuilder.append(", ");
        }
        System.out.println(stringBuilder.toString().substring(0, stringBuilder.length() - 2) + "]");
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int calcCountOfMatch(Lotto winningNumbers) {
        int countOfMatch = 0;
        for (int number : numbers) {
            countOfMatch += winningNumbers.contains(number) ? 1 : 0;
        }
        return countOfMatch;
    }
}
