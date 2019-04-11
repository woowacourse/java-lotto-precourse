package domain;

import domain.util.Constant;
import domain.util.GenarateNumber;
import domain.util.Input;

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
    public static Lotto creatLotto() {
        List<Integer> lottoNumbers = GenarateNumber.genarateUserNumber(Constant.NUMBER_OF_LOTTO_NUMBERS);
        return new Lotto(lottoNumbers);
    }

    public static String lottoListToString(Lotto lotto) {
        String lottoNumString = lotto.numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        return lottoNumString;
    }

    public static int getBonusNumber(Lotto lotto) {
        int bonusNum = Input.inputBonusNum(lotto.numbers);
        return bonusNum;
    }

    public int countMatchNumber(Lotto otherLotto) {
        int count = 0;
        for (int number : otherLotto.numbers) {
            count += this.numbers.contains(number) ? 1 : 0;
        }
        return count;
    }

    public boolean hasBonusNumber(int bonusNum) {
        if (this.numbers.contains(bonusNum)) {
            return true;
        }
        return false;
    }
}
