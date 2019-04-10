package domain;

import java.util.*;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
    public void getLottoNumber() {
        Set<Integer> set = new TreeSet<>();
        while (set.size() != 6) {
            set.add(createLottoNumber());
        }

        numbers.addAll(set);
        System.out.println(printLottoNumber(numbers));
    }

    private int createLottoNumber() {
        return ((int) (Math.random() * LOTTO_MAX_NUM) + LOTTO_MIN_NUM);
    }

    private String printLottoNumber(List<Integer> numbers) {
        return String.join(",", String.valueOf(numbers));
    }

    public void assignWinningLotto(String inputWinningLotto){
        String[] winningLottoArray = inputWinningLotto.split(",");
        for(String number : winningLottoArray){
            numbers.add(Integer.parseInt(number));
        }

        System.out.println(printLottoNumber(numbers));
    }

}
