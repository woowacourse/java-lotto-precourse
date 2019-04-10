package com.woowacourse.lotto.domain;

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
		boolean bonusResult = false;

		if (userLotto.getNumbers().contains(bonusNo)) {
			bonusResult = true;
		}
		userLotto.getNumbers().retainAll(lotto.getNumbers()); //winningLotto와 일치하는 숫자들만 userLotto에 남는다.
		Rank rank = Rank.valueOf(userLotto.getNumbers().size(), bonusResult);
		return rank;
	}
}
