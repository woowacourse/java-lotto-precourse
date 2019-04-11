package exception;

/**
 * @author delf
 */
public class NotNumberException extends NumberFormatException {
    private final static String MESSAGE = "숫자가 아닙니다.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
