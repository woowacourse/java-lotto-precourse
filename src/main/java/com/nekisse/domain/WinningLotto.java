package com.nekisse.domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNo;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNo) {
        this.winningLotto = winningLotto;
        if (winningLotto.isContainsNum(bonusNo)) {
            throw new IllegalArgumentException("보너스 숫자가 중복입니다.");
        }
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        return Rank.valueOf(winningLotto.matchGetSameNumberCount(userLotto), userLotto.isContainsNum(bonusNo));
    }

    @Override
    public String toString() {
        return String.valueOf(winningLotto);
    }
}
