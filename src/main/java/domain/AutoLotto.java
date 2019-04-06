package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 자동 로또를 생성하는 객체
 */
public class AutoLotto {
    private static final int MAX_LOTTO_SIZE = 6;
    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> makeAutoNumber() {
        numbers.clear();
        for (int i = 0; i < MAX_LOTTO_SIZE; i++) {
            numbers.add(makeRandomNum());
        }
        changeOverlapNum();
        Collections.sort(numbers);
        printNumbers();
        return numbers;
    }

    private int makeRandomNum() {
        int num = (int) (Math.random() * 45) + 1;
        return num;
    }

    private void changeOverlapNum() {
        for (int i = 1; i < MAX_LOTTO_SIZE; i++) {
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

    private void printNumbers() {
        System.out.print("[");
        for (int i = 0; i < this.numbers.size(); i++) {
            System.out.print(this.numbers.get(i) + getComma(i));
        }
        System.out.println("]");
    }

    private String getComma(int i) {
        if (i != 5) {
            return ", ";
        }
        return "";
    }
}
