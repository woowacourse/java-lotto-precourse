/*
 * @(#)Message.java
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
class Message {
    // GameRunner 문자열들
    static String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    static String LOTTO_INFO = "개를 구매했습니다.";
    static String LAST_WEEK_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    static String BONUS_NO = "보너스 볼을 입력해 주세요.";
    static String RESULT_DESCRIPTION= "%s개 일치%s(%s원)- %s개";
    static String BONUS_TRUE = ", 보너스 볼 일치";
    static String BONUS_FALSE = "";
    static String LOTTO_MATCH_RESULT_HEADER = "당첨통계";
    static String SEPARATION_LINE = "---------";
    static String RESULT_YIELD = "총 수익률은 %.3f입니다.";

    // Rank 문자열들
    static String EXCEPTION_MESSAGE = "는 유효하지 않은 값입니다.";
}
