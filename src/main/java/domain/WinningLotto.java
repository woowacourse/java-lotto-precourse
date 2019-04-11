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
		int countOfMatch = 0;
		for (int i = 0; i < userLotto.getNumbers().size(); i++) {
			countOfMatch += ((userLotto.getNumbers()).contains((lotto.getNumbers()).get(i))) ? 1 : 0;
		}
		return Rank.valueOf(countOfMatch, containBonusNumber(userLotto));
	}

	public boolean containBonusNumber(Lotto userLotto) {
		return (userLotto.getNumbers()).contains(bonusNo);
	}
}
