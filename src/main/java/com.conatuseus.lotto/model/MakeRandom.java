package com.conatuseus.lotto.model;


import java.util.*;

public class MakeRandom {
    private static final int MAX_LOTTO_VALUE = 45;
    private static final int MIN_LOTTO_VALUE = 1;

    public static List<Integer> makeRandomNumberList() {
        Set<Integer> set=new TreeSet<>();
        while (set.size() != 6) {
            int madeRandomNumber = (int) ((Math.random() * MAX_LOTTO_VALUE) + MIN_LOTTO_VALUE);
            addRandomNumber(set, madeRandomNumber);
        }
        return new LinkedList<>(set);
    }

    private static void addRandomNumber( Set<Integer> set, int randomNumber) {
        if (!set.contains(randomNumber)) {
            set.add(randomNumber);
        }
    }
}
