/*
 * WinningLotto Class
 *
 * @version 2
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
    private final Lotto lot;
    private final int bonusNo;
    public static final int WIN_NUMS_COUNT = 6;

    public WinningLotto(Lotto lot, int bonusNo) {
        this.lot = lot;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLot) {
        int countOfMatch = userLot.countMatch(lot);
        boolean matchBonus = userLot.contains(bonusNo);

        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
