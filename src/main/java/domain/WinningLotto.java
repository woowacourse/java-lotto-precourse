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

    /** 제시된 로또 번호와 당첨 번호를 맞춰보고 그에 따른 등수를 반환. */
    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.getMatchCount(this.lotto);
        boolean matchBonus = userLotto.hasNumber(this.bonusNo);
        
        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
