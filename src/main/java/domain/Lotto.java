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

    public void showBuyLotto(Lotto lottoNumber){

        System.out.println(lottoNumber.numbers);
    }

    public List<Integer> findLotto(){
        return this.numbers;
    }

    // 추가 기능 구현
}
