package domain;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import static domain.Const.*;

/**
 * 1~45 사이의 숫자를 무작위로 뽑아주는 클래스
 */
public class NumberGenerator {
    private static Random random = new Random();
    private ArrayList<Integer> randomArrList = new ArrayList<>();
    private List<Integer> numberList = new ArrayList<>();

    public NumberGenerator(int size) {
        initNumberArrList();
        makeNumberArrList(size);
    }

    public List<Integer> getNumberArrList() {
        return this.numberList;
    }

    private void initNumberArrList() {
        randomArrList.clear();
        for (int i = SELECTABLE_LOTTO_NUMBER_MIN; i <= SELECTABLE_LOTTO_NUMBER_MAX; ++i) {
            randomArrList.add(i);
        }
    }

    private void makeNumberArrList(int size) {
        numberList.clear();
        for (int i = 0; i < size; ++i) {
            int value = makeNumber(i);
            numberList.add(value);
        }
    }

    private int makeNumber(int idx) {
        int popIdx = random.nextInt(SELECTABLE_LOTTO_NUMBER_MAX - idx) + 1; // range : 1 ~ (45 - i)
        int value =  randomArrList.get(popIdx - 1);
        randomArrList.remove(popIdx - 1);
        return value;
    }
}
