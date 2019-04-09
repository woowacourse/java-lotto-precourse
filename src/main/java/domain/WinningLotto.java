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
        int countOfMatch = matchWinningNumber(userLotto);
        boolean matchBonus = false;
        if (countOfMatch == 5) {
            matchBonus = userLotto.hasNumber(bonusNo);
        }
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    public int matchWinningNumber(Lotto userLotto) {
        int countOfMatch = 0;
        for (int number: lotto.getNumbers()) {
            if (userLotto.hasNumber(number)) {
                countOfMatch ++;
            }
        }
        return countOfMatch;
    }
}
