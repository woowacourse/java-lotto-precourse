package domain;

/**
 * 당첨 번호를 담당하는 객체
 * 
 * @version 1.00 2019/04/10
 * @author 조재훈
 */
public class WinningLotto {
	private final Lotto lotto;
	private final int bonusNo;

	public WinningLotto(Lotto lotto, int bonusNo) {
		this.lotto = lotto;
		this.bonusNo = bonusNo;
	}

	public Rank match(Lotto userLotto) {
		boolean matchBonus = userLotto.isContainBonus(bonusNo);
		int countOfMatch = userLotto.getCountOfMatch(lotto);
		return Rank.valueOf(countOfMatch, matchBonus);
	}
}
