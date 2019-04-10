package domain;

import java.util.List;

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
        int countOfMatch=0;
        boolean matchBonus=false;
        for(int i=0; i<lotto.getNumbers().size(); i++) {
            if (userLotto.getNumbers().contains(lotto.getNumbers().get(i)))
                countOfMatch++;
        }
        if(userLotto.getNumbers().contains(bonusNo))
            matchBonus=true;
        return Rank.valueOf(countOfMatch,matchBonus);
    }
}
