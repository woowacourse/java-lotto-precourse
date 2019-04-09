/*
 * @(#)WinningLotto.java
 *
 * v 0.0.0
 *
 * 2019.04.09
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */
package com.kwonmc.lotto;

/**
 * 당첨 번호를 담당하는 객체
 *
 * @version 0.0.0
 * @author kwonmc
 * @author WoowahanTechCamp
 * @see Lotto
 * @see Numbers
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = countOfMatch(userLotto);
        boolean matchBonus = matchBonus(userLotto);

        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private int countOfMatch(Lotto userLotto) {
        int countOfMatch = Numbers.NONE;
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
