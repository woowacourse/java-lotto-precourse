/*
 * UserInterfaceImpl Class
 *
 * @version 1.4
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.impl;

import domain.objects.Lotto;
import domain.interfaces.UserInterface;
import domain.interfaces.ValidInterface;
import domain.utility.Utils;

import java.util.List;
import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {
    ValidInterface valid;
    Scanner sc;

    public UserInterfaceImpl(ValidInterface valid) {
        this.sc = new Scanner(System.in);
        this.valid = valid;
    }

    @Override
    public List<Integer> inputWinningLottoNumbers() {
        String winLotNums;
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        winLotNums = sc.nextLine();
        if (!isInputWinLotNumsValid(winLotNums)) {
            return inputWinningLottoNumbers();
        }
        return Utils.convertStrArrToIntList(winLotNums.split(","));
    }

    @Override
    public boolean isInputWinLotNumsValid(String winNum) {
        try {
            valid.validWinningLottoSequence(winNum);
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
    public int inputBonusNum(Lotto preWinLotto) {
        String bonusNum;
        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNum = sc.nextLine();
        if (!isInputBonusNumValid(preWinLotto, bonusNum)) {
            return inputBonusNum(preWinLotto);
        }
        return Integer.parseInt(bonusNum);
    }

    @Override
    public boolean isInputBonusNumValid(Lotto preWinLotto, String bonusNum) {
        try {
            valid.validBonusNumSequence(preWinLotto, bonusNum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void printBoughtLottos(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            printLottoNums(lotto);
        }
    }

    @Override
    public void printLottoNums(Lotto lotto) {
        System.out.println(lotto.toString());
    }
}
