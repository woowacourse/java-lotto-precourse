/*
 * Main Class
 *
 * @version 1
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain;

import domain.interfaces.UtilityInterface;
import domain.interfaces.ValidInterface;

public class Main {
    public static void main(String[] args){
        UtilityInterface utilityInterface = new UtilityInterfaceImpl();
        ValidInterface validInterface = new ValidInterfaceImpl();

        UserInterfaceImpl user = new UserInterfaceImpl(validInterface, utilityInterface);
        int c = 0;
        while(true) {
            System.out.println(c);
            user.inputWinningLottoNumbers();
            c++;
        }
    }
}
