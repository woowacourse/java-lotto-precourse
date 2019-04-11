/*
 * 클래스 이름: ErrorMessage.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/04/11
 * Copyright 2019 Inkwon Lee
 */
package domain;

/*
 * 에러 메세지를 출력해주는 클래스
 */
public enum ErrorMessage {

    INPUT_MISS_MATCH_EXCEPTION_MESSAGE("잘못 입력하셨습니다. 양의 정수만 입력해 주세요."),
    HAS_NUMBER_OF_CHIPER_MESSAGE("잘못 입력하셨습니다. 1000원 단위로 입력해 주세요."),
    HAS_MINUS_MESSAGE("음수가 입력되었습니다. 양수를 입력해 주세요."),
    HAS_BLANK_MESSAGE("빈칸이 입력되었습니다. 다시 입력해주세요."),
    OUT_OF_LOTTO_NUMBER_MESSAGE("잘못 입력하셨습니다. 1부터 45까지의 수를 입력해주세요."),
    OVERLAP_NUMBER_MESSAGE("중복된 숫자가 있습니다. 다시 입력해 주세요."),
    SIZELESS_WINNING_NUMBER_MESSAGE("6개의 숫자가 입력되지 않았습니다. 다시 입력해 주세요."),
    BONUS_NUMBER_OVERLAP_MESSAGE("보너스 숫자와 당첨된 숫자중 하나와 중복됩니다. 다시 입력해 주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
