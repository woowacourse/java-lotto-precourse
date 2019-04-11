package domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
    final static int LOTTO_MAX_NUM = 45;
    final static int LOTTO_NUM_CNT = 6;

    static List<Integer> nums = new ArrayList<>(LOTTO_MAX_NUM);

    static {
        for (int i = 0; i < LOTTO_MAX_NUM; ++i) {
            nums.add(i, i + 1);
        }
    }

    private Store() {
    }

    static private void shuffle() {
        for (int i = 0; i < LOTTO_MAX_NUM; ++i) {
            final int del = (int) (Math.random() * 100) % LOTTO_MAX_NUM;
            final int temp = nums.get(del);
            nums.add(del, nums.get(i));
            nums.add(i, temp);
        }
    }

    static public Lotto buy() {
        shuffle();
        List<Integer> lotto = new ArrayList<>(LOTTO_NUM_CNT);
        for (int i = 0; i < LOTTO_NUM_CNT; ++i) {
            lotto.add(i, nums.get(i));
        }
        return new Lotto(lotto);
    }

    static public Lotto buy(List<Integer> lotto) {
        return new Lotto(lotto);
    }
}
