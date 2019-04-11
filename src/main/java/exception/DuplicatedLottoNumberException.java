package exception;

/**
 * @author delf
 */
public class DuplicatedLottoNumberException extends IllegalArgumentException {
    private final static String MESSAGE = "중복된 숫자입니다.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
