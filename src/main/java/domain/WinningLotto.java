package domain;

import exception.DuplicatedLottoNumberException;
import exception.LottoNumberException;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) throws IllegalArgumentException {
        checkArguments(lotto, bonusNo);

        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    /* 생성 전 매개변수 확인 */
    private void checkArguments(Lotto lotto, int bonusNo) throws IllegalArgumentException {
        if (bonusNo < Lotto.MIN_NUM || bonusNo > Lotto.MAX_NUM) { // 보너스 숫자 범위 확인
            throw new LottoNumberException();
        }

        if (lotto.contains(bonusNo)) { // 보너스 숫자 중복 확인
            throw new DuplicatedLottoNumberException();
        }
    }

    public Rank match(Lotto userLotto) {
        int matchCount = lotto.getMatchCount(userLotto);
        boolean bonus = userLotto.contains(bonusNo);
        return Rank.valueOf(matchCount, bonus);
    }

}
