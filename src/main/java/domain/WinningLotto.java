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
        Rank res;
        int countOfMatch = userLotto.getCountOfMatch(lotto);
        boolean matchBonus = userLotto.contains(bonusNo);
        res = Rank.valueOf(countOfMatch, matchBonus);
        return res;
    }
}
