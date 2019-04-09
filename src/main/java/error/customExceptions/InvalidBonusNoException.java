package error.customExceptions;

/**
 * 보너스 볼이 지정된 당첨번호와 중복될 경우
 */
public class InvalidBonusNoException extends IllegalArgumentException {
    public InvalidBonusNoException() {
        super("유효한 보너스 볼이 아닙니다. 기존 당첨번호와 중복되지는 않는지 확인해 주세요.");
    }
}
