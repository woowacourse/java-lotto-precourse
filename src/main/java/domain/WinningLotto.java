package domain;

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
        int matchCount = 0;
        boolean matchBonus = false;
        for(int winNo : lotto.getNumbers()) {
            if(userLotto.getNumbers().contains(winNo))
                matchCount++;

        }
        if(userLotto.getNumbers().contains(bonusNo)) {
            matchCount++;
            matchBonus = true;
        }

        return Rank.valueOf(matchCount, matchBonus);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNo() {
        return bonusNo;
    }
}
