/*
 * @(#)MessagePrinter.java
 *
 * v 0.0.0
 *
 * 2019.04.09
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */
package com.kwonmc.lotto.util;

import com.kwonmc.lotto.GameRunner;
import com.kwonmc.lotto.Rank;
import com.kwonmc.lotto.RankList;
import com.kwonmc.lotto.consts.Numbers;
import com.kwonmc.lotto.consts.Strings;

/**
 * 게임 메시지 프린트를 위한 유틸리티 객체
 *
 * @version 0.0.0
 * @author kwonmc
 * @see GameRunner
 * @see Strings
 */
public class MessagePrinter {
    public static void purchaseAmount() {
        System.out.println(Strings.MESSAGE_PURCHASE_AMOUNT);
    }

    public static void changeAmount(int purchaseAmount) {
        int changeAmount = purchaseAmount % Numbers.LOTTO_COUNT_CRITERIA;
        if (changeAmount != 0) {
            System.out.println(String.format(Strings.MESSAGE_CHANGE_AMOUNT, changeAmount));
        }
    }

    public static void lottoInfo(int lottoCount) {
        System.out.println(lottoCount + Strings.MESSAGE_LOTTO_INFO);
    }

    public static void numberCountInvalid() {
        System.out.println(Strings.MESSAGE_LASTWEEK_INVALID_NUMBERS
                + Strings.MESSAGE_RE_INPUT_PLEASE);
    }

    public static void numberRangeInvalid() {
        System.out.println(Strings.MESSAGE_LASTWEEK_INVALID_RANGE
                + Strings.MESSAGE_RE_INPUT_PLEASE);
    }

    public static void numberRedundantInvalid() {
        System.out.println(Strings.MESSAGE_LASTWEEK_INVALID_REDUNDANT
                + Strings.MESSAGE_RE_INPUT_PLEASE);
    }

    public static void lastWeekNumber() {
        System.out.println(Strings.MESSAGE_LAST_WEEK_NUMBER);
    }

    public static void bonusNoInvalid() {
        System.out.println(Strings.MESSAGE_BONUS_INVALID
                + Strings.MESSAGE_RE_INPUT_PLEASE);
    }

    public static void bonusNo() {
        System.out.println(Strings.MESSAGE_BONUS_NO);
    }

    public static void lottoResultHead() {
        System.out.println(Strings.MESSAGE_LOTTO_MATCH_RESULT_HEADER);
        System.out.println(Strings.MESSAGE_SEPARATION_LINE);
    }

    public static void lottoResultBody(RankList rankList) {
        for (int i = rankList.size() - Numbers.SKIPPING_LAST_INDEX; i >= 0; i--) {
            Rank rank = rankList.getRankByIndex(i);
            int counts = rankList.getCountsByIndex(i);
            System.out.println(resultMessageMaker(rank, counts));
        }
    }

    private static String resultMessageMaker(Rank rank, int count) {
        return String.format(Strings.MESSAGE_RESULT_DESCRIPTION,
                rank.getCountOfMatch(),
                rank == Rank.SECOND ? Strings.MESSAGE_BONUS_TRUE : Strings.MESSAGE_BONUS_FALSE,
                rank.getWinningMoney(),
                count
        );
    }

    public static void lottoResultTail(RankList rankList, int purchaseAmount) {
        double totalYield = (double) rankList.getTotalWinningAmount() / purchaseAmount;
        System.out.println(String.format(Strings.MESSAGE_RESULT_YIELD, totalYield));
    }
}
