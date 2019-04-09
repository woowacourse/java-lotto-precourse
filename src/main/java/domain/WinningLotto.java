package domain;

import static domain.LottoConst.LOTTO_MAX_NUMBER;
import static domain.LottoConst.LOTTO_MIN_NUMBER;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        validateDuplication(lotto, bonusNo);
        validateRange(bonusNo);

        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    private void validateDuplication(Lotto lotto, int bonusNo) {
        if (lotto.hasNumber(bonusNo)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호에 포함될 수 없습니다.");
        }
    }

    private void validateRange(int bonusNo) {
        if (bonusNo < LOTTO_MIN_NUMBER || bonusNo > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 보너스 번호 입니다.");
        }
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.getCountOfMatchedNumber(lotto);
        boolean matchBonus = userLotto.hasNumber(bonusNo);

        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
