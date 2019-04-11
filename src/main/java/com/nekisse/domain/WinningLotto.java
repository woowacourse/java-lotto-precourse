package com.nekisse.domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNo;

    public WinningLotto(Lotto lotto, LottoNumber bonusNo) {
        this.lotto = lotto;
        if (lotto.isContainsNumber(bonusNo)) {
            throw new IllegalArgumentException("보너스숫자 중복");
        }
        this.bonusNo = bonusNo;
    }


    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(lotto);
    }
}
