package domain;

import java.util.*;
public class Info {

    static final String LOTTO_AMOUNTS_INPUT_PRINT = "구입금액을 입력해 주세요.";
    static final String LAST_WEEK_WINNING_NUMBER_PRINT = "지난 주 당첨 번호를 입력해 주세요.";
    static final String BONUS_BALL_INPUT_PRINT = "보너스 볼을 입력해 주세요.";
    static final String WINNINGRESULT_PRINT = "당첨 통계";
    static final String DASH = "----";

    static final String TYPE_ERROR_PRINT = "숫자만 입력해 주세요.";
    static final String MONEY_VALUE_ERROR_PRINT = "천 이상 단위로 입력해주세요.ex 1000";
    static final String RANGE_ERROR_PRINT = "숫자 범위를 초과했습니다. 범위는 1-45 입니다.";
    static final String OVERLAP_ERROR_PRINT = "중복되는 숫자 없이 입력하세요.";
    static final String WINNING_LOTTO_LENGTH_ERROR_PRINT = "6자리 숫자로 입력하세요.";

    static final int ZERO = 0;
    static final int DIVISION = 1000;
    static final int LOTTO_NUMBER_MAX_LENGTH = 6;
    static final int LOTTO_NUMBER_MAX_VALUE = 45;
    static final int LOTTO_NUMBER_MIN_VALUE = 1;
    static final int FIFTH_START = 4;

    static final String NUMBER_PATTERN = "\\d{1,2}";
    static Scanner SCAN = new Scanner(System.in);
}
