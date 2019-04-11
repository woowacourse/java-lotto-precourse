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
    	int countOfMatch = getCountOfMatch();
    	boolean matchBonus = Main.bonusWinningNumber == bonusNo;
        return Rank.valueOf(countOfMatch, matchBonus);
    }
    
    private int getCountOfMatch() {
    	List<Integer> currLottoNumbers = lotto.getNumbers();
    	int countOfMatch = 0;
    	for(int i = 0; i < currLottoNumbers.size(); i++) {
    		int currentNumber = currLottoNumbers.get(i);
    		if(Main.winningNumbers[currentNumber] > 0) {
    			++countOfMatch;
    		}
    	}
    	return countOfMatch;
    }
}
