package error.customExceptions;

/**
 * 로또 형식에 맞지 않는 숫자 리스트의 경우
 * 로또 형식 : 6개의 숫자, 중복 없음, 1~45 범위
 */
public class InvalidLottoException extends IllegalArgumentException {
    public InvalidLottoException() {
        super("로또 형식에 맞는 숫자들을 입력해 주세요.(1~45 숫자 중 중복되지 않는 6개의 숫자)");
    }
}
