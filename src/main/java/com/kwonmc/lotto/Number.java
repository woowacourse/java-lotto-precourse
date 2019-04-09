/*
 * @(#)Number.java
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
 * 숫자들을 담고 있는 객체
 *
 * @version 0.0.0
 * @author kwonmc
 */
class Number {
    private static final int ZERO = 0;
    private static final int SIX = 6;

    // WinningLotto 클래스
    static final int NONE = ZERO;

    // GameRunner 클래스
    static final int SKIPPING_LAST_INDEX = 2;
    static final int LOTTO_COUNT_CRITERIA = 1000;

    // RankList 클래스
    static final int RANKLIST_CAPACITY = SIX;

    // Lotto 클래스
    static final int EACH_LOTTO_SIZE = SIX;
    static final int TOTAL_LOTTO_POOL = 45;
}
