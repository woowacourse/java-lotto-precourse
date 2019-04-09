package domain;

import java.util.*;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    static final int TOP = 45;
    static final int BOTTOM = 1;
    static final int COUNT_OF_LOTTO_NUMBERS = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현

    public boolean hasNumber(int number) {
        Set<Integer> set = new HashSet<>();
        set.addAll(numbers);
        set.add(number);

        return set.size() == COUNT_OF_LOTTO_NUMBERS;
    }

    public static List<Lotto> generateLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < purchaseAmount/1000; i++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    private static Lotto generateLotto() {
        Set<Integer> set = new HashSet<>();

        while(set.size() < COUNT_OF_LOTTO_NUMBERS){
            set.add(generateRandomNumber(BOTTOM, TOP));
        }
        List<Integer> numberList = new ArrayList<>(set);

        return new Lotto(numberList);
    }

    private static int generateRandomNumber(int bottom, int top) {
        int number = (int)(Math.random() * (top - bottom + 1) + bottom);
        return number;
    }




    @Override
    public String toString() {
        return numbers.toString();
    }
}
