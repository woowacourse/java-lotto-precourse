package domain;

/**
 * 여러 예외 사항에 대한 에러 메시지 출력 클래스
 */
public abstract class UserInputException extends RuntimeException {
    abstract void printErrorMessage();
}
