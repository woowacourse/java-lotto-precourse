package com.kwonmc.lotto;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        // TODO 로직
        int countOfMatch = countOfMatch(userLotto);
        boolean matchBonus = matchBonus(userLotto);

        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private int countOfMatch(Lotto userLotto) {
        int countOfMatch = 0;
        for (Integer num : this.lotto.getNumbers()) {
            if (userLotto.contains(num)) {
                countOfMatch++;
            }
        }
        return countOfMatch;
    }

    private boolean matchBonus(Lotto userLotto) {
        boolean matchBonus = false;
        if (userLotto.contains(bonusNo)) {
            matchBonus = true;
        }
        return matchBonus;
    }
}
