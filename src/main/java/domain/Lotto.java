/*
 * 이 클래스는 로또 한장을 의미하는 객체입니다.
 *
 * 클래스 이름    Lotto
 * 버전 정보     1.0
 * 날짜    2019/04/11
 * 저작권   권유상
 */

package domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public List<Integer> getLottoList() {
        return numbers;
    }

}
