package domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
    public int getLottoNumber(int index){
        if (index < 0 || index >= 6) {
            return -1;
        } // numbers는 6개의 값이 있어야하므로 index가 0 ~ 5의 값이 아니라면 -1을 리턴
        return numbers.get(index);
    } // 파라미터로 받는 인덱스에 해당하는 numbers의 lotto 번호를 가져오는 메서드

    public boolean lottoNumberExist(int lottonumber){
        for (int i = 0; i < 6; i++){
            if (lottonumber == numbers.get(i))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + String.join(", ", numbers.stream().sorted().map(i -> Integer.toString(i)).collect(Collectors.toList())) + "]";
    }
}
