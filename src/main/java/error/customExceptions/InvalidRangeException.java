package error.customExceptions;

import domain.Lotto;

/**
 * 로또 숫자의 범위(1 ~ 45)가 아닌 경우
 */
public class InvalidRangeException extends IllegalArgumentException {
    public InvalidRangeException() {
        super(Lotto.FIRST_NUMBER + " ~ " + Lotto.LAST_NUMBER + " 사이의 정수를 입력해 주세요.");
    }
}
