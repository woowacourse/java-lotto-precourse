package com.conatuseus.lotto.model;


import com.conatuseus.lotto.appController.AppController;

import java.util.*;

public class MakeRandom {

    public static List<Integer> makeRandomNumberList() {
        Set<Integer> set = new TreeSet<>();
        while (set.size() != 6) {
            int madeRandomNumber = (int) ((Math.random() * AppController.MAX_LOTTO_VALUE) + AppController.MIN_LOTTO_VALUE);
            set.add(madeRandomNumber);
        }
        return new ArrayList<>(set);
    }
}
