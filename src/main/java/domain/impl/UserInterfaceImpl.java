/*
 * UserInterfaceImpl Class
 *
 * @version 2
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.impl;

import domain.interfaces.UserInterface;
import domain.interfaces.ValidInterface;
import domain.objects.Lotto;
import domain.objects.LottoResult;
import domain.objects.Rank;
import domain.utility.Utils;

import java.util.List;
import java.util.Scanner;

import static domain.objects.Rank.*;

/**
 * 사용자와 interaction 하는 interface 의 구현체
 */
public class UserInterfaceImpl implements UserInterface {
    ValidInterface valid;
    Scanner sc;

    public UserInterfaceImpl(ValidInterface valid) {
        this.sc = new Scanner(System.in);
        this.valid = valid;
    }

    @Override
    public List<Integer> inputWinningLottoNums() {
        String winLotNums;

        System.out.println("지난주 당첨 번호를 입력해주세요.");
        System.out.println("ex)1,2,3,4,5,6");
        winLotNums = sc.nextLine();
        if (!isInputWinLottoNumsValid(winLotNums)) {
            return inputWinningLottoNums();
        }
        return Utils.convertStrArrToIntList(winLotNums.split(","));
    }

    @Override
    public boolean isInputWinLottoNumsValid(String winNum) {
        try {
            valid.validWinningLottoNumsSequence(winNum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public int inputPurchasePrice() {
        String purchasePrice;

        System.out.println("구입금액을 입력해 주세요.");
        purchasePrice = sc.nextLine();
        if (!isInputPurchasePriceValid(purchasePrice)) {
            return inputPurchasePrice();
        }
        return Integer.parseInt(purchasePrice);
    }

    @Override
    public boolean isInputPurchasePriceValid(String purchasePrice) {
        try {
            valid.validPurchaseSequence(purchasePrice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public int inputBonusNum(Lotto preWinningLot) {
        String bonusNum;

        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNum = sc.nextLine();
        if (!isInputBonusNumValid(preWinningLot, bonusNum)) {
            return inputBonusNum(preWinningLot);
        }
        return Integer.parseInt(bonusNum);
    }

    @Override
    public boolean isInputBonusNumValid(Lotto preWinningLot, String bonusNum) {
        try {
            valid.validBonusNumSequence(preWinningLot, bonusNum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void printBoughtLottoList(List<Lotto> lotList) {
        System.out.println(lotList.size() + "개를 구매했습니다.");
        for (Lotto lot : lotList) {
            printLottoNums(lot);
        }
    }

    @Override
    public void printLottoNums(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    @Override
    public void printLottoStatistic(LottoResult lotResult) {
        Rank[] ranks = {FIFTH, FOURTH, THIRD, SECOND, FIRST};

        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : ranks) {
            printRankResult(rank, lotResult.getRankCount(rank));
        }
        System.out.println(String.format("총 수익률은 %.3f%% 입니다.", lotResult.getYieldRate()));
    }

    @Override
    public void printRankResult(Rank rank, int count) {
        String string = String.format("%d개 일치%s(%d원) - %d개",
                rank.getCountOfMatch(),
                rank.equals(Rank.SECOND) ? ", 보너스 볼 일치" : "",
                rank.getWinningMoney(),
                count);

        System.out.println(string);
    }
}
