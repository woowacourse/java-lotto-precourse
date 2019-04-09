/*
 * @(#)GameRunner.java
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 게임을 진행하는 객체
 *
 * @version 0.0.0
 * @author kwonmc
 * @see Game
 * @see Numbers
 * @see Strings
 */
public class GameRunner {
    private Scanner sc = new Scanner(System.in);
    private Game game = new Game();

    public void run() {
        inputUserPurchaseAmount();
        printLottoInfo();
        inputLastWeekNumberAndBonusNo();
        printLottoMatchResult();
    }

    private void inputUserPurchaseAmount() {
        purchaseAmountMessagePrinter();
        int purchaseAmount = getPurchaseAmount();
        game.setPurchaseAmount(purchaseAmount);
        changeAmountMessagePrinter(purchaseAmount);
    }

    private void purchaseAmountMessagePrinter() {
        System.out.println(Strings.MESSAGE_PURCHASE_AMOUNT);
    }

    private boolean purchaseAmountValidChecker(int purchaseAmount) {
        if (purchaseAmount < Numbers.LOTTO_COUNT_CRITERIA) {
            System.out.println(Strings.MESSAGE_PURCHASE_INVALID);
            return false;
        }
        return true;
    }

    private int getPurchaseAmount() {
        int purchaseAmount;
        do {
            purchaseAmount = sc.nextInt();
        } while (!purchaseAmountValidChecker(purchaseAmount));
        return purchaseAmount;
    }

    private void changeAmountMessagePrinter(int purchaseAmount) {
        int changeAmount = purchaseAmount % Numbers.LOTTO_COUNT_CRITERIA;
        if (changeAmount != 0) {
            System.out.println(String.format(Strings.MESSAGE_CHANGE_AMOUNT, changeAmount));
        }
    }

    private void printLottoInfo() {
        System.out.println();
        int lottoCount = countLotto();
        lottoInfoMessagePrinter(lottoCount);
        createLottoList(lottoCount);
        printLottoList();
    }

    private void lottoInfoMessagePrinter(int lottoCount) {
        System.out.println(lottoCount + Strings.MESSAGE_LOTTO_INFO);
    }

    private void createLottoList(int lottoCount) {
        ArrayList<Lotto> tmpLottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            tmpLottoList.add(Lotto.lottoMaker());
        }
        game.setMyLottoList(tmpLottoList);
    }

    private void printLottoList() {
        for (Lotto lotto : game.getMyLottoList()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    private int countLotto() {
        return (game.getPurchaseAmount() / Numbers.LOTTO_COUNT_CRITERIA);
    }

    private void inputLastWeekNumberAndBonusNo() {
        lastWeekNumberMessagePrinter();
        Lotto lotto = getLastWeek();

        bonusNoMessagePrinter();
        int bonusNo = getBonusNo(lotto);

        game.setWinningLotto(new WinningLotto(lotto, bonusNo));
    }

    private Lotto getLastWeek() {
        String[] lastWeekStr;
        List<Integer> arrayList;
        do {
            lastWeekStr = sc.next().trim().split(",");
            int[] lastWeekInt = strArrToIntArr(lastWeekStr);
            arrayList = intArrToList(lastWeekInt);
        } while (!lastWeekValidChecker(arrayList));

        return listToLotto(arrayList);
    }

    private boolean lastWeekValidChecker(List<Integer> list) {
        if (list.size() != Numbers.EACH_LOTTO_SIZE) { // 입력된 숫자의 개수가 6개가 아니면
            numberCountInvalidMessagePrinter();
            return false;
        }
        if (Collections.min(list) < 1
                || Collections.max(list) >= Numbers.TOTAL_LOTTO_POOL + 1) { // 입력된 숫자가 범위를 넘는다면
            numberRangeInvalidMessagePrinter();
            return false;
        }
        if (new HashSet<>(list).size() != Numbers.EACH_LOTTO_SIZE) { // 입력된 숫자 중 중복된 숫자가 있다면
            numberRedundantInvalidMessagePrinter();
            return false;
        }
        return true;
    }

    private void numberCountInvalidMessagePrinter() {
        System.out.println(Strings.MESSAGE_LASTWEEK_INVALID_NUMBERS
                + Strings.MESSAGE_RE_INPUT_PLEASE);
    }

    private void numberRangeInvalidMessagePrinter() {
        System.out.println(Strings.MESSAGE_LASTWEEK_INVALID_RANGE
                + Strings.MESSAGE_RE_INPUT_PLEASE);
    }

    private void numberRedundantInvalidMessagePrinter() {
        System.out.println(Strings.MESSAGE_LASTWEEK_INVALID_REDUNDANT
                + Strings.MESSAGE_RE_INPUT_PLEASE);
    }

    private void lastWeekNumberMessagePrinter() {
        System.out.println(Strings.MESSAGE_LAST_WEEK_NUMBER);
    }

    private int[] strArrToIntArr(String[] strArray) {
        return Arrays.stream(strArray)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private List<Integer> intArrToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }

    private Lotto listToLotto(List<Integer> list) {
        return new Lotto(list);
    }

    private int getBonusNo(Lotto lotto) {
        int bonusNo;
        do {
            bonusNo = sc.nextInt();
        } while (!bonusNoValidChecker(lotto, bonusNo));
        return bonusNo;
    }

    private boolean bonusNoValidChecker(Lotto lotto, int bonusNo) {
        if (lotto.contains(bonusNo)) {
            System.out.println(Strings.MESSAGE_BONUS_INVALID + Strings.MESSAGE_RE_INPUT_PLEASE);
            return false;
        }
        return true;
    }

    private void bonusNoMessagePrinter() {
        System.out.println(Strings.MESSAGE_BONUS_NO);
    }

    private void printLottoMatchResult() {
        lottoMatchResultHeadMessagePrinter();
        RankList rankList = getRankList(game.getWinningLotto());

        lottoMatchResultBodyMessagePrinter(rankList);

        lottoMatchResultTailMessagePrinter(rankList, game.getPurchaseAmount());
    }

    private RankList getRankList(WinningLotto winningLotto) {
        RankList rankList = new RankList();

        for (Lotto lotto : this.game.getMyLottoList()) {
            rankList.add(winningLotto.match(lotto));
        }

        return rankList;
    }

    private void lottoMatchResultBodyMessagePrinter(RankList rankList) {
        for (int i = rankList.size() - Numbers.SKIPPING_LAST_INDEX; i >= 0; i--) {
            Rank rank = rankList.getRankByIndex(i);
            int counts = rankList.getCountsByIndex(i);
            System.out.println(resultMessageMaker(rank, counts));
        }
    }

    private String resultMessageMaker(Rank rank, int count) {
        return String.format(Strings.MESSAGE_RESULT_DESCRIPTION,
                rank.getCountOfMatch(),
                rank == Rank.SECOND ? Strings.MESSAGE_BONUS_TRUE : Strings.MESSAGE_BONUS_FALSE,
                rank.getWinningMoney(),
                count
        );
    }

    private void lottoMatchResultHeadMessagePrinter() {
        System.out.println(Strings.MESSAGE_LOTTO_MATCH_RESULT_HEADER);
        System.out.println(Strings.MESSAGE_SEPARATION_LINE);
    }

    private void lottoMatchResultTailMessagePrinter(RankList rankList, int purchaseAmount) {
        double totalYield = (double) rankList.getTotalWinningAmount() / purchaseAmount;
        System.out.println(String.format(Strings.MESSAGE_RESULT_YIELD, totalYield));
    }
}
