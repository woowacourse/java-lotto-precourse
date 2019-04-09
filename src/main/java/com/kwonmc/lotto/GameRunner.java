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
import java.util.Scanner;

/**
 * 게임을 진행하는 객체
 *
 * @version 0.0.0
 * @author kwonmc
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
        int purchaseAmount = sc.nextInt();
        game.setPurchaseAmount(purchaseAmount);
        changeAmountMessagePrinter(purchaseAmount);
    }

    private void purchaseAmountMessagePrinter() {
        System.out.println(Strings.PURCHASE_AMOUNT);
    }

    private void changeAmountMessagePrinter(int purchaseAmount) {
        int changeAmount = purchaseAmount % Numbers.LOTTO_COUNT_CRITERIA;
        if (changeAmount != 0) {
            System.out.println(String.format(Strings.CHANGE_AMOUNT, changeAmount));
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
        System.out.println(lottoCount + Strings.LOTTO_INFO);
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
        return game.getPurchaseAmount() / Numbers.LOTTO_COUNT_CRITERIA;
    }

    private void inputLastWeekNumberAndBonusNo() {
        lastWeekNumberMessagePrinter();
        String[] lastWeekStr = sc.next().trim().split(",");
        Lotto lotto = stringArrayToLotto(lastWeekStr);

        bonusNoMessagePrinter();
        int bonusNo = sc.nextInt();

        game.setWinningLotto(new WinningLotto(lotto, bonusNo));
    }

    private Lotto stringArrayToLotto(String[] strArray) {
        int[] intArray = Arrays.stream(strArray)
                .mapToInt(Integer::valueOf)
                .toArray();
        ArrayList<Integer> lottoList = arrayToList(intArray);
        return new Lotto(lottoList);
    }

    private void lastWeekNumberMessagePrinter() {
        System.out.println(Strings.LAST_WEEK_NUMBER);
    }

    private void bonusNoMessagePrinter() {
        System.out.println(Strings.BONUS_NO);
    }

    private ArrayList<Integer> arrayToList(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }

    private void printLottoMatchResult() {
        lottoMatchResultHeaderMessagePrinter();
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
            // rankList 의 마지막 원소는 MISS 이므로 마지막 원소는 건너뛰기 위해 -2
            Rank rank = rankList.getRankByIndex(i);
            int counts = rankList.getCountsByIndex(i);
            System.out.println(resultMessageMaker(rank, counts));
        }
    }

    private String resultMessageMaker(Rank rank, int count) {
        return String.format(Strings.RESULT_DESCRIPTION,
                rank.getCountOfMatch(),
                rank == Rank.SECOND ? Strings.BONUS_TRUE : Strings.BONUS_FALSE,
                rank.getWinningMoney(),
                count
        );
    }

    private void lottoMatchResultHeaderMessagePrinter() {
        System.out.println(Strings.LOTTO_MATCH_RESULT_HEADER);
        System.out.println(Strings.SEPARATION_LINE);
    }

    private void lottoMatchResultTailMessagePrinter(RankList rankList, int purchaseAmount) {
        double totalYield = (double) rankList.getTotalWinningAmount() / purchaseAmount;
        System.out.println(String.format(Strings.RESULT_YIELD, totalYield));
    }
}
