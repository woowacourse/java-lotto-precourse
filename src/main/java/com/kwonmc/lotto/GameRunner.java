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

import com.kwonmc.lotto.consts.Numbers;
import com.kwonmc.lotto.consts.Strings;
import com.kwonmc.lotto.util.MessagePrinter;

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
        MessagePrinter.purchaseAmount();

        int purchaseAmount = getPurchaseAmount();
        game.setPurchaseAmount(purchaseAmount);

        MessagePrinter.changeAmount(purchaseAmount);
    }

    private int getPurchaseAmount() {
        int purchaseAmount;
        do {
            purchaseAmount = sc.nextInt();
        } while (!purchaseAmountValidChecker(purchaseAmount));
        return purchaseAmount;
    }

    private boolean purchaseAmountValidChecker(int purchaseAmount) {
        if (purchaseAmount < Numbers.LOTTO_COUNT_CRITERIA) {
            System.out.println(Strings.MESSAGE_PURCHASE_INVALID);
            return false;
        }
        return true;
    }

    private void printLottoInfo() {
        System.out.println();
        int lottoCount = countLotto();
        MessagePrinter.lottoInfo(lottoCount);
        createLottoList(lottoCount);
        printLottoList();
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
        MessagePrinter.lastWeekNumber();
        Lotto lotto = getLastWeek();

        MessagePrinter.bonusNo();
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
            MessagePrinter.numberCountInvalid();
            return false;
        }
        if (Collections.min(list) < 1
                || Collections.max(list) >= Numbers.TOTAL_LOTTO_POOL + 1) { // 입력된 숫자가 범위를 넘는다면
            MessagePrinter.numberRangeInvalid();
            return false;
        }
        if (new HashSet<>(list).size() != Numbers.EACH_LOTTO_SIZE) { // 입력된 숫자 중 중복된 숫자가 있다면
            MessagePrinter.numberRedundantInvalid();
            return false;
        }
        return true;
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
        if (bonusNo < 1 || bonusNo >= Numbers.TOTAL_LOTTO_POOL + 1) {
            MessagePrinter.bonusNoRangeInvalid();
            return false;
        }
        if (lotto.contains(bonusNo)) {
            MessagePrinter.bonusNoInvalid();
            return false;
        }
        return true;
    }

    private void printLottoMatchResult() {
        MessagePrinter.lottoResultHead();
        RankList rankList = getRankList(game.getWinningLotto());

        MessagePrinter.lottoResultBody(rankList);

        MessagePrinter.lottoResultTail(rankList, game.getPurchaseAmount());
    }

    private RankList getRankList(WinningLotto winningLotto) {
        RankList rankList = new RankList();

        for (Lotto lotto : this.game.getMyLottoList()) {
            rankList.add(winningLotto.match(lotto));
        }

        return rankList;
    }
}
