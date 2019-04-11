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
		int countOfMatch = getCountOfMatch(userLotto);
		boolean matchBonus = getMatchBonusNo(userLotto);

		return Rank.valueOf(countOfMatch, matchBonus);
	}

	private int getCountOfMatch(Lotto userLotto) {
		return (int) (userLotto.getNumbers().stream()
				.filter(n -> lotto.contains(n))
				.count());
	}

	private boolean getMatchBonusNo(Lotto userLotto) {
		return userLotto.contains(bonusNo);
	}
}
