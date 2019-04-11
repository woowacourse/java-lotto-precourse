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
    	int countOfMatch = getCountOfMatch(userLotto);
    	boolean matchBonus = isBonusNoMatched(userLotto);
        return Rank.valueOf(countOfMatch, matchBonus);
    }
    
    private boolean isBonusNoMatched(Lotto userLotto) {
    	List<Integer> currLottoNumbers = userLotto.getNumbers();
    	for(int i = 0; i < currLottoNumbers.size(); i++) {
    		int currentNumber = currLottoNumbers.get(i);
    		if(currentNumber == bonusNo) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private int getCountOfMatch(Lotto userLotto) {
    	List<Integer> currLottoNumbers = userLotto.getNumbers();
    	int countOfMatch = 0;
    	for(int i = 0; i < currLottoNumbers.size(); i++) {
    		int currentNumber = currLottoNumbers.get(i);
    		if(lotto.getNumbers().contains(currentNumber)) {
    			++countOfMatch;
    		}
    	}
    	return countOfMatch;
    }
}
