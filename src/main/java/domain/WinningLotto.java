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
        // TODO 로직 구현
        int countOfMatch = 0;
        boolean matchBonus = userLotto.getNumbers().contains(bonusNo);
        for (int num : userLotto.getNumbers()) {
            if (checkmatchCount(num)) {
                countOfMatch++;
            }
        }
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private boolean checkmatchCount(int num) {
        return lotto.getNumbers().contains(num);
    }
}
