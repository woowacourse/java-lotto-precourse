/*
 * UserInterfaceImpl Class
 *
 * @version 1
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain;

import domain.interfaces.UserInterface;
import domain.interfaces.ValidInterface;

import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {
    ValidInterface validInterfaceImpl;
    Scanner sc;

    public UserInterfaceImpl(ValidInterface validInterfaceImpl) {
        this.sc = new Scanner(System.in);
        this.validInterfaceImpl = validInterfaceImpl;
    }

    @Override
    public int inputPurchasePrice() {
        String purchasePrice;
        System.out.println("구입금액을 입력해 주세요.");
        purchasePrice = sc.nextLine();
        if (inputPurcahcePriceValidSequence(purchasePrice)) {
            return Integer.parseInt(purchasePrice);
        } else {
            return inputPurchasePrice();
        }
    }

    @Override
    public boolean inputPurcahcePriceValidSequence(String purchasePrice) {
        try {
            validInterfaceImpl.validPurcahseSequence(purchasePrice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
