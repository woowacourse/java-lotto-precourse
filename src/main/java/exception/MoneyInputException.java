package exception;

/**
 * @author delf
 */
public class MoneyInputException extends IllegalArgumentException {
    private final static String MESSAGE = "돈이 너무 적거나 많습니다.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
