package domain;

/**
 * 당첨 번호를 담당하는 객체
 */
class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.getCountOfMatch(lotto);
        boolean matchBonus = userLotto.hasNumber(bonusNumber);

        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
