package domain;

import java.util.List;

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
		int matchCount = 0;
		List<Integer> userLottoNum = userLotto.getNumbers();
		for (Integer num : lotto.getNumbers()) {
			matchCount += userLottoNum.contains(num) ? 1 : 0;
		}
		return Rank.valueOf(matchCount, userLottoNum.contains(bonusNo));
	}
}
