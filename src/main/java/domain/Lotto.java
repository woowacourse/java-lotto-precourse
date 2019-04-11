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

    public void printLottoNumbers() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int number : numbers){
            stringBuilder.append(number);
            stringBuilder.append(", ");
        }
        System.out.println(stringBuilder.toString().substring(0, stringBuilder.length()-2) + "]");
    }

}
