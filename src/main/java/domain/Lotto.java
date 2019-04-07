package domain;

import java.util.*;

/**
 * 로또 한장을 의미하는 객체
 * 1부터 45 사이의 숫자를 중복되지않게 임의로 6개 뽑음.
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
    public void printLottoNums(){
        List<String> numberStr = convertIntListToStringList();
        String printNumStr = "[" + String.join(",",numberStr) + "]";
        System.out.println(printNumStr);
    }

    private List<String> convertIntListToStringList(){
        List<String> numberStr = new ArrayList(numbers.size());
        for(int num : numbers){
            numberStr.add(Integer.toString(num));
        }
        return numberStr;
    }
}
