package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLotto {
    private List<Integer> numbers = new ArrayList<Integer>();

    public List<Integer> makeAutoNumber() {
        numbers.clear();
        for (int i = 0; i < 6; i++) {
            numbers.add(makeRandomNum());
        }
        changeOverlapNum();
        Collections.sort(numbers);
        return numbers;
    }

    private int makeRandomNum() {
        int num = (int) (Math.random() * 45) + 1;
        return num;
    }

    private void changeOverlapNum() {
        for (int i = 1; i < 6; i++) {
            i = (isResetNum(isFindOverlapNum(i), i)) ? i - 1 : i;
        }
    }

    private boolean isFindOverlapNum(int i) {
        boolean same = false;
        for (int j = 0; j < i; j++) {
            same = isSameNum(i, j);
            j = (same) ? i : j;
        }
        return same;
    }

    private boolean isSameNum(int i, int j) {
        if (numbers.get(i) == numbers.get(j)) {
            return true;
        }
        return false;
    }

    private boolean isResetNum(boolean b, int i) {
        if (b) {
            numbers.set(i, makeRandomNum());
        }
        return b;
    }
}
