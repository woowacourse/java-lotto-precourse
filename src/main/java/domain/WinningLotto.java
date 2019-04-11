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

    @Override
    public String toString() {
        return lotto.toString() + String.format(" + [%d]", bonusNo);
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = lotto.countEqualNumbers(userLotto);
        return Rank.valueOf(countOfMatch, userLotto.contains(bonusNo));
    }
}
