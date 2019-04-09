/*
 * @(#)Strings.java
 *
 * v 0.0.0
 *
 * 2019.04.09
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */
package com.kwonmc.lotto;

/**
 * 문자열 상수들을 위한 객체
 *
 * @version 0.0.0
 * @author kwonmc
 */
class Strings {
    // GameRunner 문자열들
    static final String MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    static final String MESSAGE_LOTTO_INFO = "개를 구매했습니다.";
    static final String MESSAGE_LAST_WEEK_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    static final String MESSAGE_BONUS_NO = "보너스 볼을 입력해 주세요.";
    static final String MESSAGE_RESULT_DESCRIPTION = "%s개 일치%s(%s원)- %s개";
    static final String MESSAGE_BONUS_TRUE = ", 보너스 볼 일치";
    static final String MESSAGE_BONUS_FALSE = "";
    static final String MESSAGE_LOTTO_MATCH_RESULT_HEADER = "당첨통계";
    static final String MESSAGE_SEPARATION_LINE = "---------";
    static final String MESSAGE_RESULT_YIELD = "총 수익률은 %.3f입니다.";
    static final String MESSAGE_CHANGE_AMOUNT = "거스름돈은 %s원 입니다.";
    static final String MESSAGE_PURCHASE_INVALID = "최소 구매 금액은 1000원 입니다.";
    static final String MESSAGE_BONUS_INVALID = "이미 당첨번호에 포함된 번호입니다.";
    static final String MESSAGE_LASTWEEK_INVALID_NUMBERS = "당첨번호는 6개입니다.";
    static final String MESSAGE_LASTWEEK_INVALID_REDAUNDANT = "중복된 숫자가 포함되어 있습니다.";

    static final String MESSAGE_RE_INPUT_PLEASE = " 다시 입력해주세요.";

    // Rank 문자열들
    static final String MESSAGE_EXCEPTION = "는 유효하지 않은 값입니다.";

    // Lotto
    static final String OPEN_SQUARE_BRACKET = "[";
    static final String CLOSE_SQUARE_BRACKET = "]";
    static final String LOTTO_NUMBER_DELIMITER = ", ";
}
