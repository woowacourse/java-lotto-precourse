/*
 * UserInterfaceImpl Class
 *
 * @version 1.1
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain;

import domain.interfaces.UserInterface;
import domain.interfaces.UtilityInterface;
import domain.interfaces.ValidInterface;

import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {
    ValidInterface valid;
    UtilityInterface utility;
    Scanner sc;

    public UserInterfaceImpl(ValidInterface valid, UtilityInterface utility) {
        this.sc = new Scanner(System.in);
        this.valid = valid;
        this.utility = utility;
    }

    @Override
    public int[] inputWinningLottoNumbers() {
        String winLotNums;
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        winLotNums = sc.nextLine();
        if (!isInputWinLotNumsValid(winLotNums)) {
            return inputWinningLottoNumbers();
        }
        return utility.convertStrArrToIntArr(winLotNums.split(","));
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
}
