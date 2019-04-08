package com.conatuseus.lotto;

import java.util.*;

public class MakeRandom {
    private static final int MAX_LOTTO_VALUE = 45;
    private static final int MIN_LOTTO_VALUE = 1;
    private static final Random random=new Random();

    public static List<Integer> makeRandomNumberList() {
        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        while (list.size() != 6) {
            int madeRandomNumber = (random.nextInt() + MAX_LOTTO_VALUE) + MIN_LOTTO_VALUE;
            addRandomNumber(list, set, madeRandomNumber);
        }
        return list;
    }

    private static void addRandomNumber(List<Integer> list, Set<Integer> set, int randomNumber) {
        if (!set.contains(randomNumber)) {
            list.add(randomNumber);
            set.add(randomNumber);
        }
    }
}
