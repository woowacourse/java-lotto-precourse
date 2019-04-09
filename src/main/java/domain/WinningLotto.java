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
        boolean match = false;

        for (Integer number : userLotto.getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                countOfMatch++;
            }

            if (!match) {
                match = (bonusNo == number);
            }
        }

        return Rank.valueOf(countOfMatch, match);
    }
}
