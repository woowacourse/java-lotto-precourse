package error.customExceptions;

/**
 * 비어있는 값이 있을 경우
 */
public class UndefinedException extends IllegalArgumentException {
    public UndefinedException() {
        super("정의되지 않은 값이 있습니다. 입력값이 비어있지는 않은지 확인해 주세요.");
    }
}
