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
        int countOfMatch = 0;

        for (int number : userLotto.getNumbers()) {
            countOfMatch = (lotto.getNumbers().contains(number)) ? countOfMatch + 1 : countOfMatch;
        }

        return Rank.valueOf(countOfMatch, matchBonus(userLotto));
    }

    private boolean matchBonus(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNo);
    }
}