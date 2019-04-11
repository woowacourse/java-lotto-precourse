package domain;

import java.util.Iterator;
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
        // TODO 로직 구현
    	int matchCount = 0;
    	boolean bonusMatched = false;
    	List<Integer> userLottoNumbers = userLotto.getNumbers();
    	List<Integer> winningNumbers = this.lotto.getNumbers();
    	
    	
    	Iterator winningNumberIterator = winningNumbers.iterator();
    	while(winningNumberIterator.hasNext()) {
    		int winningNumber = (int)winningNumberIterator.next();
	    	Iterator userLottoIterator = userLottoNumbers.iterator();
	    	while(userLottoIterator.hasNext()) {
	    		int userNum = (int)userLottoIterator.next();
        		if (winningNumber == userNum) {
        			matchCount++;
        		}
        	}
	    	
	    	if (bonusNo == winningNumber) {
	    		bonusMatched = true;
	    	}
    	}
    	
    	return Rank.valueOf(matchCount, bonusMatched);
    	
    }
}
