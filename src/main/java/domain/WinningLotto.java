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
		int matchCount = (int)userLotto.getNumbers()
								.stream()
								.filter(number -> lotto.contains(number))
								.count();
		return Rank.valueOf(matchCount, containsBonusNo(userLotto));
	}
	
	public boolean containsBonusNo(Lotto userLotto) {
		return userLotto.contains(bonusNo);
	}
}
