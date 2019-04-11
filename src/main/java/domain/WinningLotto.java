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

	private boolean matchBonus(Lotto userLotto) {
		List<Integer> userLottoNumbers = userLotto.getNumbers();
		return userLottoNumbers.contains(this.bonusNo);
	}
	
	private int countPlusOneIfListContainsNumber(int count, List<Integer> integerList, int number) {
		if (integerList.contains(number)) {
			count++;
		}
		return count;
	}
	
	private int countMatch(Lotto userLotto) {
    	List<Integer> userLottoNumbers = userLotto.getNumbers();
    	List<Integer> winningLottoNumbers = this.lotto.getNumbers();
    	int countOfMatch = 0;
    	
    	for (int userLottoNumber : userLottoNumbers) {
    		countOfMatch = countPlusOneIfListContainsNumber(countOfMatch, winningLottoNumbers, userLottoNumber);
    	}
    	return countOfMatch;
    }

	public Rank match(Lotto userLotto) {
		return Rank.valueOf(countMatch(userLotto), matchBonus(userLotto));
	}
}
