/*
 * WinningLotto Class
 *
 * @version 1.3
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.objects;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;
    public static final int WIN_NUMS_COUNT = 6;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.countMatch(lotto);
        boolean matchBonus = userLotto.contains(bonusNo);

        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
