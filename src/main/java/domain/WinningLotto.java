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
        int count = 0;
        boolean bonus = userLotto.isContainBonus(this.bonusNo);
        for (int i = 0; i < LottoConstant.LOTTO_MAX_COUNT; i++) {
            count += userLotto.isContainNumber(this.lotto, i);
        }
        Rank rank = Rank.valueOf(count, bonus);
        return rank;
    }
}
