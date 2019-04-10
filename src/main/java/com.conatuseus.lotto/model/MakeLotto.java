/*
 *  @(#)MakeLotto.java       3.00    2019/04/10
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 *  conatuseus@gmail.com
 */
package com.conatuseus.lotto.model;


import com.conatuseus.lotto.appController.AppController;

import java.util.*;

/**
 * 사용자의 로또를 생성하기 위한 클래스
 * author 사명기
 * @version 3.00    2019년 4월 10일
 */
public class MakeLotto {

    /* Random 수를 생성해서 ArrayList로 반환. 따로 sorting하지 않기위해 TreeSet에 넣음 */
    public static List<Integer> makeRandomNumberList() {
        Set<Integer> set = new TreeSet<>();
        while (set.size() != AppController.LOTTO_LENGTH) {
            int madeRandomNumber = (int) ((Math.random() * AppController.MAX_LOTTO_VALUE) + AppController.MIN_LOTTO_VALUE);
            set.add(madeRandomNumber);
        }
        return new ArrayList<>(set);
    }
}
