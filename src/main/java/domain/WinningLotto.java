package domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private static final String DUPLICATED_BONUS_NUMBER_MENT = "보너스 숫자는 1 이상 45 이하의 숫자로 당첨번호와 중복되지 않아야 됩니다.";

    private final Lotto lotto;
    private final int bonusNo;

    WinningLotto(Lotto lotto, int bonusNo) {
        if(lotto.hasBall(bonusNo) || isBonusBallOutRange(bonusNo)){
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_MENT);
        }
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    private boolean isBonusBallOutRange(int bonusBall) {
        return (bonusBall < Lotto.MIN_LOTTO_NUMBER || bonusBall > Lotto.MAX_LOTTO_NUMBER);
    }

    Rank match(Lotto userLotto) {
        int matchNumberCount = userLotto.countMatchedNumber(lotto);
        boolean isBonusBallMatched = userLotto.hasBall(bonusNo);
        return Rank.valueOf(matchNumberCount, isBonusBallMatched);
    }
}
