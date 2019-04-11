package exception;

import domain.Lotto;

/**
 * @author delf
 */
public class LottoNumberException extends IllegalArgumentException {
    private final static String MESSAGE = String.format("%d에서 %d 사이의 숫자를 입력해 주세요.", Lotto.MIN_NUM, Lotto.MAX_NUM);

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
