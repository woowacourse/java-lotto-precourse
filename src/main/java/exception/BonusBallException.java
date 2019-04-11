package exception;

import domain.Lotto;

/**
 * @author delf
 */
public class BonusBallException extends IllegalArgumentException {
    private final static String MESSAGE = String.format("%d개의 숫자를 입력해 주세요.", Lotto.PICK_NUM);

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
