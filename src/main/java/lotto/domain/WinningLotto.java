package lotto.domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        validateRange(bonusNo);
        validateDuplication(lotto, bonusNo);
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.calculateCountOfMatch(lotto);
        boolean matchBonus = userLotto.isBonusNoDuplicate(bonusNo);

        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private void validateRange(int bonusNo) {
        if (Lotto.LOTTO_MAX_NUMBER < bonusNo || Lotto.LOTTO_MIN_NUMBER > bonusNo)
            throw new IllegalArgumentException("보너스 볼은 " + Lotto.LOTTO_MIN_NUMBER + "~" + Lotto.LOTTO_MAX_NUMBER + "만 입력 가능합니다.");
    }

    private void validateDuplication(Lotto lotto, int bonusNo) {
        if (lotto.isBonusNoDuplicate(bonusNo))
            throw new IllegalArgumentException("당첨 번호와 보너스 볼은 중복이 불가능합니.");
    }

    @Override
    public String toString() {
        return lotto.toString() + " bonus = " + bonusNo;
    }
}
