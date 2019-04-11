package domain;

/**
 * 숫자 외 입력 사항에 대한 예외 처리 클래스
 */
public class UserInputMismatchException extends UserInputException {

    @Override
    public void printErrorMessage() {
        System.out.println("숫자만 입력가능합니다.");
    }
}
