/*
 *  @(#)Main.java       3.00    2019/04/10
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 *  conatuseus@gmail.com
 */

package com.conatuseus.lotto;

import com.conatuseus.lotto.appController.AppController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AppController appController = new AppController();
        appController.run();
    }
}
