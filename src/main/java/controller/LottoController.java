package controller;

import domain.Lotto;
import domain.WinningLotto;

import java.util.*;

public class LottoController {

    private static final int LOTTO_BOUND = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;

    private Random random = new Random();
    private List<Lotto> lottoList = new ArrayList<>();
    private WinningLotto winningLotto;

    public LottoController(int money) {
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottoList.add(createLotto());
        }
    }

    public void setWinningLotto(Lotto lotto, int bonusNo) {
        this.winningLotto = new WinningLotto(lotto, bonusNo);
    }

    private Lotto createLotto() {
        Set<Integer> numSet = new TreeSet<>();

        while(numSet.size() != LOTTO_SIZE) {
            int num = random.nextInt(LOTTO_BOUND) + 1;
            numSet.add(num);
        }

        return new Lotto(new ArrayList<>(numSet));
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
