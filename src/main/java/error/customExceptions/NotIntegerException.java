package error.customExceptions;

/**
 * 정수 입력이 아닌 경우
 */
public class NotIntegerException extends IllegalArgumentException {
    public NotIntegerException() {
        super("정수로 입력해 주세요.");
    }
}
