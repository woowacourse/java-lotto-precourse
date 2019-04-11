package exception;

/**
 * @author delf
 */
public class NumberFormatException extends java.lang.NumberFormatException {
    private final static String MESSAGE = "숫자가 아니거나, 범위를 벗어납니다.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
