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

    private int isContains(Lotto userLotto, int countNumber) {
        if (userLotto.getNumbers().contains(countNumber)) {
            return 1;
        }

        return 0;
    }

    public Rank match(Lotto userLotto) {
        int matchCount = 0;
        boolean bonusPoint = userLotto.getNumbers().contains(bonusNo);

        for (int i = 0; i < userLotto.getNumbers().size(); i++) {
            matchCount += isContains(userLotto, lotto.getNumbers().get(i));
        }

        return Rank.valueOf(matchCount, bonusPoint);
    }
}
