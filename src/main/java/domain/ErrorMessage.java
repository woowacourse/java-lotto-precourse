package domain;

public enum ErrorMessage {

    INPUTMISSMATCHEXCEPTION_MESSAGE("잘못 입력하셨습니다. 정수만 입력해 주세요."),
    HAS_NUMBER_OF_CHIPER_MESSAGE("잘못 입력하셨습니다. 1000원 단위로 입력해 주세요."),
    HAS_MINUS_MESSAGE("음수가 입력되었습니다. 양수를 입력해 주세요."),
    HAS_BLANK_MESSAGE("빈칸이 입력되었습니다. 다시 입력해주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
