package domain;

/**
 * 중복 처리 예외 클래스
 */
public class UserInputDuplicateNumberException extends UserInputException {
    @Override
    void printErrorMessage() {
        System.out.println("중복된 숫자가 있으면 안됩니다.");
    }
}
