package controller;

import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;

import java.util.*;

public class LottoController {

    private static final int LOTTO_BOUND = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoList = new ArrayList<>();
    private WinningLotto winningLotto;
    private Map<Rank, Integer> rankMap = new HashMap<>();

    public LottoController(int money) {
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottoList.add(createLotto());
        }
    }

    public void setWinningLotto(Lotto lotto, int bonusNo) {
        this.winningLotto = new WinningLotto(lotto, bonusNo);
        matchLottoList();
    }

    private void matchLottoList() {
        for (Lotto lotto : lottoList) {
            Rank rank = winningLotto.match(lotto);
            rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
        }
    }

    private Lotto createLotto() {
        Random random = new Random();
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

    public Map<Rank, Integer> getRankMap() {
        return rankMap;
    }

    public double getLottoYield() {
        int totalPrizes = 0;

        for (Rank rank : rankMap.keySet()) {
            totalPrizes += rank.getWinningMoney() * rankMap.get(rank);
        }

        return (double) totalPrizes / (lottoList.size() * LOTTO_PRICE);
    }

}
