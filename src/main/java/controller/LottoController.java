package controller;

import domain.Lotto;

import java.util.*;

public class LottoController {

    private List<Lotto> lottoList = new ArrayList<>();
    private static final int LOTTO_BOUND = 45;
    private static final int LOTTO_SIZE = 6;
    private Random random = new Random();

    public LottoController(int money) {
        for (int i = 0; i < money / 1000; i++) {
            lottoList.add(createLotto());
        }
    }

    private Lotto createLotto() {
        Set<Integer> numSet = new HashSet<>();

        while(numSet.size() != LOTTO_SIZE) {
            int num = random.nextInt(LOTTO_BOUND) + 1;
            numSet.add(num);
        }

        return new Lotto(new ArrayList<>(numSet));
    }


}
